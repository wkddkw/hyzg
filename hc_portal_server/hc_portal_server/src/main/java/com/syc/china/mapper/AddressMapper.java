package com.syc.china.mapper;


import com.syc.china.pojo.Address;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface AddressMapper extends Mapper<Address> , IdListMapper<Address,Integer> {
}
