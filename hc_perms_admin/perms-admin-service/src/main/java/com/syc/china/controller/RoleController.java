package com.syc.china.controller;

import com.syc.china.pojo.TbRole;
import com.syc.china.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:dkw
 * @data:2019/11/20
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取所有的角色
     * @return
     */
    @GetMapping("/getRoles")
    public ResponseEntity<List<TbRole>> getRoles(){
       List<TbRole> roles = roleService.getRoles();
       return  ResponseEntity.ok(roles);
    }
}
