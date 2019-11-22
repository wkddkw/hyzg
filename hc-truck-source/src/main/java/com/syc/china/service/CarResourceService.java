package com.syc.china.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyzg.common.enums.ExceptionEnums;
import com.hyzg.common.exception.HyzgException;
import com.hyzg.common.pojo.PageResult;
import com.syc.china.mapper.*;
import com.syc.china.pojo.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;


@Service
public class CarResourceService {
    @Autowired
    private CarResourceMapper carResourceMapper;
    @Autowired
    private CarTypeMapper carTypeMapper;
    @Autowired
    private ProDetailTypeMapper proDetailTypeMapper;
    @Autowired
    private TransTypeMapper transTypeMapper;
    @Autowired
    private UnitMapper unitMapper;

    public PageResult<CarResource> queryCarResourceByPageAndSort(Integer page, Integer size, String sortBy, String key) {
        //实现分页查询,最多查询10条
        PageHelper.startPage(page,Math.min(size,10));
        Example example=new Example(CarResource.class);
        //设置模糊查询
        if (StringUtils.isNotBlank(key)){
            example.createCriteria().andLike("startCity","%"+key+"%").orEqualTo("startCity",key);
        }
        //默认排序
        example.setOrderByClause("last_update_time desc");

        List<CarResource> carResources = carResourceMapper.selectByExample(example);

        for (CarResource carResource:carResources){
            System.out.println(carResource);
            //将车类型id换为车类型
            Integer carTypeId = carResource.getCarTypeId();
            CarType carType = carTypeMapper.selectByPrimaryKey(carTypeId);
            carResource.setCarType(carType.getCarType());
            //单位id转为单位
            Integer unitId = carResource.getUnitId();
            Unit unit = unitMapper.selectByPrimaryKey(unitId);
            carResource.setUnit(unit.getUnit());
            //货源类型id转换
            Integer proTypeId = carResource.getProDetailTypeId();
            ProDetailType proDetailType = proDetailTypeMapper.selectByPrimaryKey(proTypeId);
            carResource.setProType(proDetailType.getProDetailType());
            //运输类型id转化
            Integer transTypeId = carResource.getTransTypeId();
            TransType transType = transTypeMapper.selectByPrimaryKey(transTypeId);
            carResource.setTransType(transType.getTransType());
        }

        PageInfo<CarResource> pageInfo = new PageInfo<>(carResources);
        // 封装分页对象
        PageResult<CarResource> result = new PageResult<>();
        result.setItems(carResources);
        result.setTotal(pageInfo.getTotal());
        result.setTotalPage(Long.valueOf(pageInfo.getPages()));
        return result;
    }

    public void saveCarResource(CarResource carResource) {
        if (carResource.getStartProvince()!=null&&carResource.getStartCity()!=null&&carResource.getStartArea()!=null
            &&carResource.getEndProvince()!=null&&carResource.getEndCity()!=null&&carResource.getEndArea()!=null
            &&carResource.getCarTypeId()!=null&&carResource.getLinkMan()!=null&&carResource.getTel()!=null
        ){
            carResource.setCreateTime(new Date());
            carResource.setLastUpdateTime(new Date());
            carResourceMapper.insert(carResource);
        }
        else
            throw new HyzgException(ExceptionEnums.CAR_RESOURCE_SEND_ERROR);
    }

    public void deleteCarResource(Long id) {
        carResourceMapper.deleteByPrimaryKey(id);
    }

    public void updateCarResource(CarResource carResource) {
        System.out.println(carResource);
        carResource.setLastUpdateTime(new Date());
        carResourceMapper.updateByPrimaryKey(carResource);
    }
}
