package com.syc.china.service;

import com.hyzg.common.enums.ExceptionEnums;
import com.hyzg.common.exception.HyzgException;
import com.syc.china.mapper.ProDetailTypeMapper;
import com.syc.china.pojo.ProDetailType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ProDetailTypeService {
    @Autowired
    private ProDetailTypeMapper proDetailTypeMapper;

    public List<ProDetailType> select() {
        List<ProDetailType> proDetailTypes = proDetailTypeMapper.selectAll();
        if (CollectionUtils.isEmpty(proDetailTypes)){
            throw new HyzgException(ExceptionEnums.PRO_DETAIL_TYPE_IS_EMPTY);
        }
        return proDetailTypes;
    }

    public String selectByProDetailTypeId(Integer proDetailTypeId) {
        ProDetailType proDetailType = proDetailTypeMapper.selectByPrimaryKey(proDetailTypeId);
        if (proDetailType == null){
            throw new HyzgException(ExceptionEnums.PRO_DETAIL_TYPE_IS_EMPTY);
        }
        return proDetailType.getProDetailType();
    }
}
