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

    /**
     * 增加用户
     * @param user 要插入的user对象
     */
    @PostMapping("/insert")
    public void  insertUser(TbUser user){
        userService.insertUser(user);
    }

    /**
     * 更新用户
     * @param user 要更改的User
     */
    @PutMapping("/update")
    public void updateUser(TbUser user){
        userService.updateUser(user);
    }

    /**
     * 查找用户的条件
     * @param name 姓名
     * @param phone 电话
     * @param idCard 身份证号
     * @return 返回 符合条件的用户的集合
     */
    @GetMapping("/selectAll")
    public List<TbUser> selectAllByCondition(@RequestParam(value = "name",required = false) String name,
                                             @RequestParam(value = "phone",required = false) String phone,
                                             @RequestParam(value = "idCard",required = false)String idCard){
        List<TbUser> tbUsers = userService.selectAllByCondition(name, phone, idCard);
        return tbUsers;
    }

    /**
     * 根据传来的id删除用户
     * @param did 删除id
     */
    @DeleteMapping("/delete/{did}")
    public void deleteUser(@PathVariable Integer did){
        userService.deleteUser(did);
    }

    /**
     * 更改角色
     * @param uid 用户的id
     * @param rid 要更改的角色id
     */
    @PutMapping("/changeRole")
    public void changeRole(Integer uid,Integer rid){
        userService.changeRole(uid,rid);
    }

}
