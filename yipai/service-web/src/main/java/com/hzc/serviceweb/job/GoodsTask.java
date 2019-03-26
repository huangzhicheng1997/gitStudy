package com.hzc.serviceweb.job;

import com.hzc.serviceweb.Vo.GoodsToUser;
import com.hzc.serviceweb.entity.Goods;
import com.hzc.serviceweb.entity.GoodsExample;
import com.hzc.serviceweb.entity.User;
import com.hzc.serviceweb.mapper.GoodsMapper;
import com.hzc.serviceweb.mapper.MyGoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
/*
@Slf4j
@Component
@Deprecated
public class GoodsTask {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MyGoodsMapper mygoodsMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Value("$(spring.mail.username)")
    private String from;
    @Scheduled(cron = "0/30 * * * * ?")
    @Transactional
    public void sendEmail(){
        //有try 得手动回滚
        DefaultTransactionDefinition def=new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(def);

        log.info("***********************sendEmail定时任务开始执行****************************");
        List<GoodsToUser> goodsToUsers = mygoodsMapper.getGoodsAndUserByStatus("3");
        if(goodsToUsers!=null && goodsToUsers.size()>0){
            MimeMessage mailMessage=mailSender.createMimeMessage();
            MimeMessageHelper message=new MimeMessageHelper(mailMessage);
                for (GoodsToUser goodsToUser : goodsToUsers) {
                    try {

                    message.setFrom("1220820912@qq.com");
                    message.setTo(goodsToUser.getUser().getEmail());
                        log.info("***********************发送到"+goodsToUser.getUser().getEmail()+"****************************");
                        message.setSubject("订单通知");
                        message.setText("您的订单号" + goodsToUser.getId() + "商品名" + goodsToUser.getGoodName() + "已经成交");
                        //更新为已通知
                        Goods goods=new Goods();
                        goods.setStatus("4");
                        goods.setId(goodsToUser.getId());
                        goodsMapper.updateByPrimaryKeySelective(goods);
                        mailSender.send(mailMessage);

                    }catch (Exception e){
                        log.info("***********************sendEmail定时任务异常 订单号为:"+goodsToUser.getId()+"****************************");
                        //回滚
                        dataSourceTransactionManager.rollback(transactionStatus);
                        e.printStackTrace();
                    }
                }


        }
    }
}
*/
