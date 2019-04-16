package com.hzc.serviceuser.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hzc.serviceuser.Handler.TransactionDetailHandler;
import com.hzc.serviceuser.dto.enums.StatusCodeEnum;
import com.hzc.serviceuser.dto.response.BaseRs;
import com.hzc.serviceuser.dto.response.pageRs;
import com.hzc.serviceuser.dto.vo.TransactionDetailVo;
import com.hzc.serviceuser.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/Transaction")
public class TransactionDetailController {
    @Autowired
    private TransactionDetailHandler transactionDetailHandler;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/getCurrUserTransaction")
    public pageRs getCurrUserTransaction(HttpServletRequest request, Integer page, Integer limit){
        //获取user
        String token = request.getHeader("token");
        String json = redisUtil.get(token);
        JSONObject jsonObject = JSONObject.parseObject(json);
        String userid = jsonObject.getString("userid");
        List<TransactionDetailVo> transaction = transactionDetailHandler.getTransaction(userid);
        if(transaction.isEmpty()){
            return new pageRs(0,"成功", Collections.emptyList(),0);
        }else {
            return new pageRs(0,"成功",transaction,transaction.size());
        }
    }

    /**
     * 取消竞拍
     * @param id
     * @return
     */
    @RequestMapping("/deleteTransaction")
    public BaseRs cancelDeleteTranction(String id){
        Boolean flag = transactionDetailHandler.deleteTransaction(id);
        if(flag){
            return new BaseRs(StatusCodeEnum.SUCCESS);
        }else {
            return new BaseRs(StatusCodeEnum.FAILD);
        }
    }

}
