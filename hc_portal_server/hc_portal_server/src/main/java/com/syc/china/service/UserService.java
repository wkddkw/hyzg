package com.syc.china.service;


import com.syc.china.mapper.UserMapper;
import com.syc.china.pojo.User;
import common.enums.ExceptionEnums;
import common.exception.HcException;
import common.utils.CodecUtils;
import common.utils.NumberUtils;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private AmqpTemplate amqpTemplate;

    static final String KEY_PREFIX = "user:code:phone:";


    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        User user1 = userMapper.selectOne(user);
        if(user1==null){
            throw new HcException(ExceptionEnums.NOT_IS_FOUND);
        }
        if(!user1.getPassword().equals(CodecUtils.md5Hex1(password))){
            throw  new HcException(ExceptionEnums.NOT_IS_FOUND);
        }
        return user1;
    }

    /**
     * 注册
     * @param user
     * @param code
     */
    public void registry(User user, String code) {

        String key = KEY_PREFIX+user.getPhone();
        String codeCache = this.redisTemplate.opsForValue().get(key);
        if(!code.equals(codeCache)){
            throw new HcException(ExceptionEnums.INVALID_VERFIY_CODE);
        }
        user.setCreate_time(new Date());

        user.setPassword(CodecUtils.md5Hex1(user.getPassword()));
        //写入数据库
        Boolean boo = userMapper.insertSelective(user) ==1;
        //如果注册成功,删除redis中的code
        if(boo){
            try {
                redisTemplate.delete(code);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生成验证码
     * @param phone
     * @return
     */
    public Boolean sendCode(String phone) {
        //生成验证码
        String code = NumberUtils.generateCode(6);
        try {
            //发送短信
            Map<String,String> msg = new HashMap<>();
            msg.put("code",code);
            msg.put("phone",phone);
            amqpTemplate.convertAndSend("sms.verify.code",msg);
            //将验证码存入到redis
            redisTemplate.opsForValue().set(KEY_PREFIX+phone,code,5, TimeUnit.MINUTES);
            return true;
        } catch (AmqpException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 完善信息
     * @return
     */
    public User writeInfo(User user) {
        int insert = userMapper.insert(user);
        if(insert>0){
            return user;
        }
        return null;
    }
}
