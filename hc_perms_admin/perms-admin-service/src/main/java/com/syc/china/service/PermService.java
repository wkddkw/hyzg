package com.syc.china.service;

import com.syc.china.mapper.PermMapper;
import com.syc.china.pojo.TbPerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:dkw
 * @data:2019/11/21
 */

@Service
public class PermService {

    @Autowired
    private PermMapper permMapper;

    public List<TbPerm> getPerms(Integer id) {
       return permMapper.selectPermSByRid(id);
    }
}
