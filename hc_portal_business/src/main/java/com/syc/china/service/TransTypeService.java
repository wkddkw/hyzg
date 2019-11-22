package com.syc.china.service;

import com.hyzg.common.enums.ExceptionEnums;
import com.hyzg.common.exception.HyzgException;
import com.syc.china.mapper.TransTypeMapper;
import com.syc.china.pojo.TransType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TransTypeService {
    @Autowired
    private TransTypeMapper transTypeMapper;

    public List<TransType> select() {
        List<TransType> transTypes = transTypeMapper.selectAll();
        if (CollectionUtils.isEmpty(transTypes)){
            throw new HyzgException(ExceptionEnums.TRANS_TYPE_IS_EMPTY);
        }
        return transTypes;
    }

    public String selectByTransTypeId(Integer transTypeId) {
        TransType transType = transTypeMapper.selectByPrimaryKey(transTypeId);
        if (transType == null){
            throw new HyzgException(ExceptionEnums.TRANS_TYPE_IS_EMPTY);
        }
        return transType.getTransType();
    }
}
