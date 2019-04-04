package com.hzc.serviceweb.Controller;

import com.hzc.serviceweb.Dao.GoodsRepository;
import com.hzc.serviceweb.Service.FeignClient;
import com.hzc.serviceweb.Vo.GoodsVo;
import com.hzc.serviceweb.entity.GoodsInfo;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class testController {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    private FeignClient feignClient;
    @Value("$(spring.mail.username)")
    private String from;
@GetMapping("/get")
    public String get(){
    String hello_world = feignClient.ts("hello world");
    return hello_world;
}

    @GetMapping("/test")
    public void test() throws MessagingException {
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper message=new MimeMessageHelper(mimeMessage);
        message.setFrom("1220820912@qq.com");
        message.setTo("2491009023@qq.com");
        message.setSubject("测试主题");
        message.setText("测试内容");
        mailSender.send(mimeMessage);
    }


}
