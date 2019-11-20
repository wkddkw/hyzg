package com.syc.china.service;

import com.syc.china.mapper.RoleMapper;
import com.syc.china.pojo.TbRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author:dkw
 * @data:2019/11/20
 */
@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public List<TbRole> getRoles() {
        List<TbRole> roles = roleMapper.selectAll();
        if (CollectionUtils.isEmpty(roles)){
            return null;
        }
        return roles;
    }
}
