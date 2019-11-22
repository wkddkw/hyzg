package com.syc.china.service;

import com.hyzg.common.enums.ExceptionEnums;
import com.hyzg.common.exception.HyzgException;
import com.syc.china.mapper.UnitMapper;
import com.syc.china.pojo.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UnitService {
    @Autowired
    private UnitMapper unitMapper;

    public List<Unit> select() {
        List<Unit> units = unitMapper.selectAll();
        if (CollectionUtils.isEmpty(units)){
            throw new HyzgException(ExceptionEnums.UNIT_IS_EMPTY);
        }
        return units;
    }

    public String selectByUnitId(Integer unitId) {
        Unit unit = unitMapper.selectByPrimaryKey(unitId);
        if (unit == null){
            throw new HyzgException(ExceptionEnums.UNIT_IS_EMPTY);
        }
        return unit.getUnit();
    }
}
