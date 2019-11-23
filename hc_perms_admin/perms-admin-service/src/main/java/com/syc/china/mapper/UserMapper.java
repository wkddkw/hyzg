package com.syc.china.mapper;

import com.syc.china.pojo.TbUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author:dkw
 * @data:2019/11/19
 */

public interface UserMapper extends Mapper<TbUser> {

    @Update("UPDATE tb_user set role_id=#{rid} where id=#{uid}")
    void changeRole(@Param(value = "uid") Integer uid, @Param(value = "rid") Integer rid);
}
