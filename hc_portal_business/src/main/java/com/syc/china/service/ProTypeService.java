package com.syc.china.service;

import com.hyzg.common.enums.ExceptionEnums;
import com.hyzg.common.exception.HyzgException;
import com.syc.china.mapper.ProTypeMapper;
import com.syc.china.pojo.ProType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ProTypeService {
    @Autowired
    private ProTypeMapper proTypeMapper;

    public List<ProType> select() {
        List<ProType> proTypes = proTypeMapper.selectAll();
        if (CollectionUtils.isEmpty(proTypes)){
            throw new HyzgException(ExceptionEnums.PRO_TYPE_IS_EMPTY);
        }
        return proTypes;
    }

    public String selectByProTypeId(Integer proTypeId) {
        ProType proType = proTypeMapper.selectByPrimaryKey(proTypeId);
        if (proType == null){
            throw new HyzgException(ExceptionEnums.PRO_TYPE_IS_EMPTY);
        }
        return proType.getProType();
    }
}
