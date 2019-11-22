package com.syc.china.controller;


import com.syc.china.pojo.User;
import com.syc.china.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
//登录
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam("username") String username, @RequestParam("password") String password){
        User user = userService.login(username,password);
        return ResponseEntity.ok(user);
    }
//注册
    @PostMapping("registry")
    public ResponseEntity<Void> reistry(User user,String code){
        userService.registry(user,code);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 生成验证码
     */
    @PostMapping("/code")
    public ResponseEntity<Void> makeCode(@RequestParam("phone")String phone){
        Boolean boo = userService.sendCode(phone);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

//完善信息
    @PostMapping("info")
    public ResponseEntity<User> writeInfo(User user){
        User use = userService.writeInfo(user);
        return ResponseEntity.ok(use);
    }


}
