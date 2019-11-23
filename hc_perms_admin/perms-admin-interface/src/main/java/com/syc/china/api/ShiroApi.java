package com.syc.china.api;

import com.syc.china.pojo.TbUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author:dkw
 * @data:2019/11/23
 */

public interface ShiroApi {

    @RequestMapping("/toLogin")
    public String toLogin();

    @GetMapping("/index")
    public String index();

    /**
     * 登录接口 shiro角色权限配置
     * @param user 传来的对象
     * @return
     */
    @RequestMapping("/login")
    public String login(TbUser user);


    //注解验角色和权限
    @RequiresRoles("企业车主")
    @RequiresPermissions("search_car_resource")
    @RequestMapping("/searchCar")
    public ModelAndView searchCar();
}
