package com.syc.china.controller;

import com.syc.china.pojo.TbUser;
import com.syc.china.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:dkw
 * @data:2019/11/19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public void  insertUser(TbUser user){
        userService.insertUser(user);
    }

    @PutMapping("/update")
    public void updateUser(TbUser user){
        userService.updateUser(user);
    }

    @GetMapping("/selectAll")
    public List<TbUser> selectAllByCondition(@RequestParam(value = "name",required = false) String name,
                                             @RequestParam(value = "phone",required = false) String phone,
                                             @RequestParam(value = "idCard",required = false)String idCard){
        List<TbUser> tbUsers = userService.selectAllByCondition(name, phone, idCard);
        return tbUsers;
    }

    @DeleteMapping("/delete/{did}")
    public void deleteUser(@PathVariable Integer did){
        userService.deleteUser(did);
    }

    @PutMapping("/changeRole")
    public void changeRole(Integer uid,Integer rid){
        userService.changeRole(uid,rid);
    }

    @GetMapping("/try")
    public ModelAndView tryIN(){
        return new ModelAndView("first");
    }

}
