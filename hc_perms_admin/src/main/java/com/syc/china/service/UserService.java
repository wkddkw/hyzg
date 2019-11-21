package com.syc.china.service;

import com.syc.china.mapper.UserMapper;
import com.syc.china.pojo.TbUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author:dkw
 * @data:2019/11/19
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertUser(TbUser user) {
        int insert = userMapper.insert(user);
    }

    public void updateUser(TbUser user) {
               userMapper.updateByPrimaryKeySelective(user);

    }

    public List<TbUser> selectAllByCondition(String name, Integer phone, Integer idCard) {
        Example example=new Example(TbUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isBlank(name)){
            criteria.andLike("name","%"+name+"%");
        }
        if (phone!=null){
            criteria.andEqualTo("phone",phone);
        }
        if (idCard!=null){
            criteria.andEqualTo("idCard",idCard);
        }
        List<TbUser> tbUsers = userMapper.selectByExample(example);
        return tbUsers;
    }

    public void deleteUser(Integer did) {
        userMapper.deleteByPrimaryKey(did);
    }

    public void changeRole(Integer uid, Integer rid) {
            userMapper.changeRole(uid,rid);
    }

    public TbUser selectByUsername(String username) {
        TbUser user=new TbUser();
        user.setName(username);
        List<TbUser> select = userMapper.select(user);
        if (!CollectionUtils.isEmpty(select)){
            return select.get(0);
        }
        return null;
    }
}
