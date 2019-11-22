package com.syc.china.service;

import com.syc.china.mapper.AddressMapper;
import com.syc.china.pojo.Address;
import common.enums.ExceptionEnums;
import common.exception.HcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
@Service
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;


    /**
     * 省市区联动查询
     * @param id
     * @return
     */
    public List<Address> selectAddress(List<Integer> id) {
        List<Address> address = addressMapper.selectByIdList(id);
        if(CollectionUtils.isEmpty(address)){
            throw new HcException(ExceptionEnums.NOT_IS_FOUND);
        }
        return address;
    }
}
