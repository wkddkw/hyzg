package com.syc.china.service;

import com.hyzg.common.enums.ExceptionEnums;
import com.hyzg.common.exception.HyzgException;
import com.syc.china.mapper.CarTypeMapper;
import com.syc.china.pojo.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CarTypeService {
    @Autowired
    private CarTypeMapper carTypeMapper;

    public List<CarType> select() {
        List<CarType> carTypes = carTypeMapper.selectAll();
        if (CollectionUtils.isEmpty(carTypes)){
            throw new HyzgException(ExceptionEnums.CAR_TYPE_IS_EMPTY);
        }
        return carTypes;
    }

    public String selectByCarTypeId(Integer carTypeId) {
        CarType carType = carTypeMapper.selectByPrimaryKey(carTypeId);
        if (carType == null){
            throw new HyzgException(ExceptionEnums.CAR_TYPE_IS_EMPTY);
        }
        return carType.getCarType();
    }
}
