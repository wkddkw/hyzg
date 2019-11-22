package com.syc.china.service;

import com.hyzg.common.enums.ExceptionEnums;
import com.hyzg.common.exception.HyzgException;
import com.syc.china.mapper.PriceUnitMapper;
import com.syc.china.pojo.PriceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class PriceUnitService {
    @Autowired
    private PriceUnitMapper priceUnitMapper;

    public List<PriceUnit> select() {
        List<PriceUnit> priceUnits = priceUnitMapper.selectAll();
        if (CollectionUtils.isEmpty(priceUnits)){
            throw new HyzgException(ExceptionEnums.PRICE_UNIT_IS_EMPTY);
        }
        return priceUnits;
    }

    public String selectByPriceUnitId(Integer priceUnitId) {
        PriceUnit priceUnit = priceUnitMapper.selectByPrimaryKey(priceUnitId);
        if (priceUnit == null){
            throw new HyzgException(ExceptionEnums.PRICE_UNIT_IS_EMPTY);
        }
        return priceUnit.getPriceUnit();
    }
}
