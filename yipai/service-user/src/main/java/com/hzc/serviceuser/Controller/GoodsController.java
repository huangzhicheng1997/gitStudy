package com.hzc.serviceuser.Controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import com.hzc.serviceuser.Handler.GoodsHandler;
import com.hzc.serviceuser.Handler.TransactionDetailHandler;
import com.hzc.serviceuser.Handler.UploadImageHandler;
import com.hzc.serviceuser.dto.GoodsDetailDto;
import com.hzc.serviceuser.dto.enums.StatusCodeEnum;
import com.hzc.serviceuser.dto.param.GoodsRq;
import com.hzc.serviceuser.dto.response.BaseRs;
import com.hzc.serviceuser.dto.response.pageRs;
import com.hzc.serviceuser.dto.vo.GoodsVo;
import com.hzc.serviceuser.entity.Goods;
import com.hzc.serviceuser.entity.TransactionDetail;
import com.hzc.serviceuser.mapper.TransactionDetailMapper;
import com.hzc.serviceuser.service.FeignClient;
import com.hzc.serviceuser.utils.CopyObjUtil;
import com.hzc.serviceuser.utils.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsHandler goodsHandler;
    @Autowired
    private UploadImageHandler uploadImageHandler;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private TransactionDetailHandler transactionDetailHandler;
    @Autowired
    private FeignClient feignClient;
    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    @RequestMapping("/getGoods")
    public GoodsVo getGoods(){
        GoodsVo<List> goods = goodsHandler.getGoods();
        return goods;
    }

    /**
     * 上传图片
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public BaseRs uploadImages(@RequestParam("file")MultipartFile file, HttpServletResponse response) throws IOException {
        String result = uploadImageHandler.upLoadQNImg(file);
        return new BaseRs(StatusCodeEnum.SUCCESS,result);
    }

    /**
     * 上架商品接口
     * @param goodsRq
     * @return
     */
    @PostMapping("/addGoods")
    public BaseRs addGoods(GoodsRq goodsRq, HttpServletRequest request){
        //获取user
        String token = request.getHeader("token");
        String json = redisUtil.get(token);
        JSONObject jsonObject = JSONObject.parseObject(json);
        String userid = jsonObject.getString("userid");

        Goods goods=new Goods();
        goods.setUserId(userid);
        goods.setAuctionPrice(goodsRq.getGoodPrice());
        goods.setGoodPrice(goodsRq.getGoodPrice());
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String data = dateFormat.format(new Date());
        goods.setCreateTime(data);
        //处理字符串
        String detailImage = goodsRq.getDetailImage();
        if(StringUtils.isEmpty(detailImage)){
            return new BaseRs(StatusCodeEnum.NETERROR);
        }
        String[] detailImgs= detailImage.split(";");
        if(detailImgs.length==1){
            goods.setDetailImg1(detailImgs[0]);
        }else if(detailImgs.length==2){
            goods.setDetailImg1(detailImgs[0]);
            goods.setDetailImg2(detailImgs[1]);
        }else if(detailImgs.length==3){
            goods.setDetailImg1(detailImgs[0]);
            goods.setDetailImg2(detailImgs[1]);
            goods.setDetailImg3(detailImgs[2]);
        }
        goods.setGoodDescribe(goodsRq.getGoodDescribe());
        goods.setGoodName(goodsRq.getGoodName());
        goods.setId(UUID.randomUUID().toString());
        goods.setImgSrc(goodsRq.getCoverImage());
        goods.setLimitedTime(goodsRq.getLimited_time());
        goods.setStatus("1");
        Boolean flag = goodsHandler.addGoods(goods);
        if(flag){
            return new BaseRs(StatusCodeEnum.SUCCESS);
        }else{
            return new BaseRs(StatusCodeEnum.FAILD);
        }

    }

    /**
     * 获取商品详情
     * @param id
     * @return
     */
    @GetMapping("/getGood")
    public BaseRs<Goods> getGoodsById(String id,HttpServletRequest request){
        String token = request.getHeader("token");
        String json = redisUtil.get(token);
        JSONObject user = JSONObject.parseObject(json);
        Goods good = goodsHandler.getGoodsById(id);
        GoodsDetailDto goodsDetailDto = CopyObjUtil.cloneObj(good, GoodsDetailDto.class);
        List<TransactionDetail> transactionDetails = transactionDetailHandler.getTransactionDetail(id, user.getString("userid"));
        if(transactionDetails.isEmpty()){
            goodsDetailDto.setUserIsAuction(false);
        }else {
            goodsDetailDto.setUserIsAuction(true);
        }
        BaseRs<Goods> baseRs=new BaseRs<>(StatusCodeEnum.SUCCESS,goodsDetailDto);
        if(good==null){
            baseRs=new BaseRs<>(StatusCodeEnum.FAILD);
        }
        return baseRs;
    }

    /**
     * 竞拍
     * @param goodsId
     * @return
     */
    @RequestMapping("/doAuction")
    public BaseRs doAuction(String goodsId,HttpServletRequest request,String auctionPrice){
        BaseRs<Goods> baseRs = new BaseRs<>(StatusCodeEnum.FAILD);
        if(StringUtils.isEmpty(goodsId)){
            return baseRs;
        }
        TransactionDetail transactionDetail=new TransactionDetail();
        Goods goods = goodsHandler.getGoodsById(goodsId);

        String token = request.getHeader("token");
        String json = redisUtil.get(token);
        JSONObject user = JSONObject.parseObject(json);
        transactionDetail.setAuctionUserId(user.getString("userid"));
        transactionDetail.setCtime(Long.valueOf(System.currentTimeMillis()/1000).toString());
        transactionDetail.setUtime(transactionDetail.getCtime());
        transactionDetail.setGoodsId(goodsId);
        transactionDetail.setUserId(goods.getUserId());
        transactionDetail.setGoodsId(goods.getId());
        transactionDetail.setPrice(auctionPrice);
        Boolean flag=null;
        //保证多线程下 数据库的就竞拍价格只会越来越高 低的价格不会覆盖高的价格
        synchronized(this){
        Goods goodsById = goodsHandler.getGoodsById(goodsId);
        if(Integer.valueOf(auctionPrice)<=Integer.valueOf(goodsById.getAuctionPrice())){
            return new BaseRs(StatusCodeEnum.PRICEERROR);
        }
        flag = transactionDetailHandler.doAuction(transactionDetail);
        }
        if(!flag){
          return baseRs;
        }
        return new BaseRs(StatusCodeEnum.SUCCESS);
    }


    /**
     * 成交
     * @param id
     * @return
     */
    @RequestMapping("/Deal")
    public BaseRs  Deal(String id) {
        TransactionDetail maxDetail = transactionDetailMapper.getMaxDetail(id);
        if(maxDetail==null){
            return  new BaseRs<>(StatusCodeEnum.NOAUCTIONMAN);
        }
        Goods goodsById = goodsHandler.getGoodsById(id);
        goodsById.setStatus("3");
        Boolean flag = goodsHandler.Deal(goodsById);
        BaseRs<Goods> baseRs = new BaseRs<>(StatusCodeEnum.SUCCESS);

        if (flag == false) {
            return  new BaseRs<>(StatusCodeEnum.FAILD);
        }
        return baseRs;
    }

    @RequestMapping("/getMyGoods")
    public pageRs getMyGoods(HttpServletRequest request){
        String token = request.getHeader("token");
        String json = redisUtil.get(token);
        JSONObject user = JSONObject.parseObject(json);
        String userid = user.getString("userid");
        List<Goods> ls = goodsHandler.getGoodsByUserId(userid);
        if(ls.isEmpty()){
            return new pageRs(0,"成功",Collections.emptyList(),0);
        }else {
            return new pageRs(0,"成功",ls,ls.size());
        }

    }

    @RequestMapping("/deleteGoods")
    public BaseRs deleteGoods(String id){
        Boolean flag = goodsHandler.deleteGoods(id);
        if(flag==true){
            return new BaseRs(StatusCodeEnum.SUCCESS);
        }else {
            return new BaseRs(StatusCodeEnum.FAILD);
        }
    }

}
