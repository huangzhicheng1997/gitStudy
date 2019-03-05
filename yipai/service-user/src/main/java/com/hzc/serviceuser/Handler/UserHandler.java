package com.hzc.serviceuser.Handler;

import com.hzc.ResponseBase;
import com.hzc.api.enums.ResultCode;
import com.hzc.serviceuser.dto.param.LoginRq;
import com.hzc.serviceuser.dto.vo.UserLoginVo;
import com.hzc.serviceuser.entity.User;
import com.hzc.serviceuser.entity.UserExample;
import com.hzc.serviceuser.mapper.UserMapper;
import com.hzc.serviceuser.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Slf4j
@Component
public class UserHandler {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 注册一条用户信息
     * @param user
     * @return
     */
    public ResponseBase doRegist(User user) {

        int i = userMapper.insertSelective(user);
        log.debug("-----------------------"+i+"----------------------");
        if(i>0){
            return new ResponseBase(ResultCode.SUCCESS);
        }
        return new ResponseBase(ResultCode.SYSTEM_ERROR);
    }

    /**
     * 通过id查user
     * @param id
     * @return
     */
    public User getUserById(String id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
    /**
     * 查询
     */
    public List<User> getUserInfo(User user){
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(user.getAdmintel()!=null){
            criteria.andAdmintelEqualTo(user.getAdmintel());
        }else if(user.getEmail()!=null){
            criteria.andEmailEqualTo(user.getEmail());
        }else{
            criteria.andUsernameEqualTo(user.getUsername());
        }
        List<User> users = userMapper.selectByExample(userExample);
        return users;

    }

    /**
     * 登录
     * @return
     * @param loginRq
     */
    public UserLoginVo doLogin(LoginRq loginRq) {
        User user=new User();
        user.setPassword(loginRq.getPwd());
        //手机登录
        if(loginRq.getPhone()!=null){
            user.setAdmintel(loginRq.getPhone());
            List<User> userInfo = this.getUserInfo(user);
            //手机号是否存在
            if(userInfo==null || userInfo.size()==0){
                return new UserLoginVo(ResultCode.FAIL);
            }
            //判断密码
            if(!userInfo.get(0).getPassword().equals(user.getPassword())){
                return new UserLoginVo(ResultCode.FAIL);
            }
            //生成token
            String token= UUID.randomUUID().toString();
            redisUtil.set(token,userInfo.get(0));
            return new UserLoginVo(ResultCode.SUCCESS,token);
        }else{
        // 邮箱登陆
            user.setEmail(loginRq.getEmail());
            List<User> userInfo = this.getUserInfo(user);
            //邮箱是否存在
            if(userInfo==null || userInfo.size()==0){
                return new UserLoginVo(ResultCode.FAIL);
            }
            //判断密码
            if(!userInfo.get(0).getPassword().equals(user.getPassword())){
                return new UserLoginVo(ResultCode.FAIL);
            }
            String token= UUID.randomUUID().toString();
            redisUtil.set(token,userInfo.get(0));
            return new UserLoginVo(ResultCode.SUCCESS,token);
        }

    }

    /**
     * 更新user
     * @param user
     * @return
     */
    public Boolean updateUser(User user){
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(user.getUserid());
        int i = userMapper.updateByExampleSelective(user,example);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}
