package com.syc.china.mapper;

import com.syc.china.pojo.TbPerm;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author:dkw
 * @data:2019/11/21
 */

public interface PermMapper extends Mapper<TbPerm> {

    @Select("SELECT tp.* from tb_role_perms rp,tb_perm tp where rp.perms_id=tp.id and rp.role_id=#{0}")
    List<TbPerm> selectPermSByRid(Integer id);
}
