package com.syc.china.mapper;

import com.syc.china.pojo.TbRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author:dkw
 * @data:2019/11/20
 */
public interface RoleMapper extends Mapper<TbRole> {

    @Select("select r.*,tp.perm from tb_role r LEFT JOIN tb_role_perms rp on r.id=rp.role_id LEFT JOIN tb_perm tp on rp.perms_id=tp.id where r.id=#{0}")
    List<TbRole> selectRoleAndPerms(Integer roleId);
}
