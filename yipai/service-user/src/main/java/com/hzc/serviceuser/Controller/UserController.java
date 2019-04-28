package com.hzc.serviceuser.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzc.ResponseBase;
import com.hzc.api.enums.ResultCode;
import com.hzc.serviceuser.Handler.UploadImageHandler;
import com.hzc.serviceuser.Handler.UserHandler;
import com.hzc.serviceuser.dto.enums.StatusCodeEnum;
import com.hzc.serviceuser.dto.param.LoginRq;
import com.hzc.serviceuser.dto.param.RegistRq;
import com.hzc.serviceuser.dto.param.UpdateUserRq;
import com.hzc.serviceuser.dto.response.BaseRs;
import com.hzc.serviceuser.dto.vo.UserLoginVo;
import com.hzc.serviceuser.entity.User;
import com.hzc.serviceuser.param.UserInfo;
import com.hzc.serviceuser.utils.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserHandler userHandler;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UploadImageHandler uploadImageHandler;
    /**
     * 注册
     *
     * @param registRq
     * @return
     */
    @RequestMapping("/regist")
    public ResponseBase doRegist(RegistRq registRq) {
        User user = new User();
        if (registRq.getPhone() != null) {
            user.setAdmintel(registRq.getPhone());
            user.setUsername(registRq.getPhone());
        }
        if (registRq.getEmail() != null) {
            user.setEmail(registRq.getEmail());
            user.setUsername(registRq.getEmail());
        }
        user.setPassword(registRq.getPwd());
        user.setStatus(1);
        user.setUserid(UUID.randomUUID().toString());
        ResponseBase responseBase = userHandler.doRegist(user);
        return responseBase;
    }

    /**
     * 验证用户名或邮箱的唯一性
     *
     * @param registRq
     * @return
     */
    @RequestMapping("/userVerify")
    public ResponseBase doVerify(RegistRq registRq) {
        User user = new User();
        if (registRq.getEmail() != null) {
            user.setEmail(registRq.getEmail());
        } else if(registRq.getPhone()!=null){
            user.setAdmintel(registRq.getPhone());
        }else{
           user.setUsername(registRq.getUsername());
        }
        List<User> userInfo = userHandler.getUserInfo(user);
        if (userInfo != null && userInfo.size() > 0) {
            return new ResponseBase(ResultCode.FAILD_VERIFY);
        } else {
            return new ResponseBase(ResultCode.SUCCESS_VERIFY);

        }

    }

    /**
     * 登陆
     * @param loginRq
     * @return
     */
    @RequestMapping("/login")
    public UserLoginVo doLogin(LoginRq loginRq){
        return  userHandler.doLogin(loginRq);
    }

    /**
     * 根据token登录
     * @param request
     * @return
     */
    @RequestMapping("/token")
    public BaseRs token(HttpServletRequest request){
        String token = request.getHeader("token");
        String loginInfo = redisUtil.get(token);
        JSONObject jsonObject = JSON.parseObject(loginInfo);
        return new BaseRs<>(StatusCodeEnum.SUCCESS,jsonObject);
    }

    /**
     * 登出
     * @param request
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        String token = request.getHeader("token");
        redisUtil.delete(token);
        UserInfo.remove();
        return "";
    }

    /**
     * 上传图片
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public BaseRs test(@RequestParam("file") MultipartFile multipartFile,HttpServletRequest request) throws IOException {
        String token = request.getHeader("token");
        String us = redisUtil.get(token);
        JSONObject jsonObject = JSONObject.parseObject(us);
        User user = userHandler.getUserById(jsonObject.getString("userid"));
        InputStream inputStream = multipartFile.getInputStream();
        String s = uploadImageHandler.upLoadQNImg(multipartFile);
        user.setUserImg(s);
        redisUtil.set(token,user);
        Boolean flag = userHandler.updateUser(user);
        if(flag){
            return new BaseRs(StatusCodeEnum.SUCCESS,s);
        }else{
            return new BaseRs(StatusCodeEnum.FAILD);
        }

    }
    /**
     * 更新用户信息
     */
    @PostMapping("/updateUser")
    public BaseRs UpdateUserInfo(HttpServletRequest request, UpdateUserRq updateUserRq){
        String token = request.getHeader("token");
        String Json = redisUtil.get(token);
        JSONObject jsonObject = JSONObject.parseObject(Json);
        User user=new User();
        user.setUsername(updateUserRq.getUsername());
        user.setUserid(jsonObject.getString("userid"));
        user.setEmail(updateUserRq.getEmail());
        user.setAdmintel(updateUserRq.getPhone());
        user.setUserImg(jsonObject.getString("userImg"));
        user.setStatus(Integer.valueOf(jsonObject.getString("status")));
        redisUtil.set(token,user);
        Boolean flag = userHandler.updateUser(user);

        if(flag){
            return new BaseRs(StatusCodeEnum.SUCCESS);
        }else{
            return new BaseRs(StatusCodeEnum.FAILD);
        }
    }


}
