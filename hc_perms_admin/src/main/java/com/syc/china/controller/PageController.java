package com.syc.china.controller;

import com.syc.china.pojo.TbUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author:dkw
 * @data:2019/11/21
 */
@Controller
public class PageController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/login")
    public String login(TbUser user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getName(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("企业车主");
//            subject.checkPermissions("query", "search_car_resource");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("账号或密码错误！");
        } catch (AuthorizationException e) {
            e.printStackTrace();
            System.out.println("没有权限");
        }
        return "index";
    }
    //注解验角色和权限
    @RequiresRoles("企业车主")
    @RequiresPermissions("search_car_resource")
    @RequestMapping("/searchCar")
    public ModelAndView searchCar() {
        return new ModelAndView("searchCarResource");
    }

    @RequestMapping(value = "/loginOut")
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/searchCar";
    }
}
