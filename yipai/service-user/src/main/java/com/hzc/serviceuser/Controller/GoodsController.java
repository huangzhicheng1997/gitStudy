package com.hzc.serviceuser.Controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.hzc.serviceuser.Handler.GoodsHandler;
import com.hzc.serviceuser.Handler.UploadImageHandler;
import com.hzc.serviceuser.dto.enums.StatusCodeEnum;
import com.hzc.serviceuser.dto.param.GoodsRq;
import com.hzc.serviceuser.dto.response.BaseRs;
import com.hzc.serviceuser.dto.vo.GoodsVo;
import com.hzc.serviceuser.entity.Goods;
import com.hzc.serviceuser.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsHandler goodsHandler;
    @Autowired
    private UploadImageHandler uploadImageHandler;
    @Autowired
    private RedisUtil redisUtil;
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
    public BaseRs uploadImages(@RequestParam("file")MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String result = uploadImageHandler.upLoadQNImg(inputStream, null);
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
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd hh:mm;ss");
        String data = dateFormat.format(new Date());
        goods.setCreateTime(data);
        //处理字符串
        String detailImage = goodsRq.getDetailImage();
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
    public BaseRs<Goods> getGoodsById(String id){
        Goods good = goodsHandler.getGoodsById(id);
        BaseRs<Goods> baseRs=new BaseRs<>(StatusCodeEnum.SUCCESS,good);
        if(good==null){
            baseRs=new BaseRs<>(StatusCodeEnum.FAILD);
        }
        return baseRs;
    }



}
