package com.syc.china.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyzg.common.enums.ExceptionEnums;
import com.hyzg.common.exception.HyzgException;
import com.hyzg.common.pojo.PageResult;
import com.syc.china.mapper.CarResourceMapper;
import com.syc.china.pojo.CarKey;
import com.syc.china.pojo.CarResource;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class CarResourceService {

    @Autowired
    private CarResourceMapper carResourceMapper;

    @Autowired
    private CarTypeService carTypeService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private ProDetailTypeService proDetailTypeService;
    @Autowired
    private TransTypeService transTypeService;

    public void insertCarResource(CarResource carResource) {
        carResource.setAvailableTime(new Date());
        carResource.setBackTime(new Date());
        carResource.setCreateTime(new Date());
        carResource.setLastUpdateTime(new Date());
        int rows = carResourceMapper.insert(carResource);
        if (rows <= 0){
            throw new HyzgException(ExceptionEnums.CAR_RESOURCE_SEND_ERROR);
        }
    }

    public PageResult<CarResource> queryCarResourceByPage(Integer page, Integer rows, CarKey carKey) {

        // 设置分页，每页最多100条记录
        PageHelper.startPage(page,Math.min(rows,100));

        Example example = new Example(CarResource.class);
        Example.Criteria criteria = example.createCriteria();
        // 过滤
        if (carKey != null){
            if (StringUtils.isNotBlank(carKey.getStartProvince())){
                criteria.andEqualTo("startProvince",carKey.getStartProvince());
            }
            if (StringUtils.isNotBlank(carKey.getStartCity())){
                criteria.andEqualTo("startCity",carKey.getStartCity());
            }
            if (StringUtils.isNotBlank(carKey.getStartArea())){
                criteria.andEqualTo("startArea",carKey.getStartArea());
            }
            if (StringUtils.isNotBlank(carKey.getEndProvince())){
                criteria.andEqualTo("endProvince",carKey.getEndProvince());
            }
            if (StringUtils.isNotBlank(carKey.getEndCity())){
                criteria.andEqualTo("endCity",carKey.getEndCity());
            }
            if (StringUtils.isNotBlank(carKey.getEndArea())){
                criteria.andEqualTo("endArea",carKey.getEndArea());
            }
            if (carKey.getCarTypeId() != null){
                criteria.andEqualTo("carTypeId",carKey.getCarTypeId());
            }
            if (carKey.getTransTypeId() != null){
                criteria.andEqualTo("transTypeId",carKey.getTransTypeId());
            }
        }

        //默认排序
        example.setOrderByClause("last_update_time desc");

        // 查询
        List<CarResource> carResources = carResourceMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(carResources)){
            throw new HyzgException(ExceptionEnums.CAR_RESOURCE_IS_EMPTY);
        }
        for (CarResource cr : carResources){
            setCarResourceData(cr);
        }

        PageInfo<CarResource> pageInfo = new PageInfo<>(carResources);

        // 封装分页信息
        PageResult<CarResource> result = new PageResult<>();
        result.setTotalPage((long) pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setItems(carResources);

        return result;

    }

    // 根据Id查询车源信息
    public CarResource queryCarResourceById(Long id) {
        CarResource carResource = carResourceMapper.selectByPrimaryKey(id);
        if (carResource == null){
            throw new HyzgException(ExceptionEnums.CAR_RESOURCE_IS_EMPTY);
        }
        setCarResourceData(carResource);
        return carResource;
    }

    /**
     * 抽取出来用来填充，用户要看的数据
     * @param carResource
     */
    private void setCarResourceData(CarResource carResource){
        // 通过车辆类型Id查询车辆类型
        carResource.setCarType(carTypeService.selectByCarTypeId(carResource.getCarTypeId()));
        // 通过单位Id查询单位
        carResource.setUnit(unitService.selectByUnitId(carResource.getUnitId()));
        // 通过货物详情类Id查询货物详情类
        carResource.setProDetailType(proDetailTypeService.selectByProDetailTypeId(carResource.getProDetailTypeId()));
        // 通过线路类型Id查询线路类型
        carResource.setTransType(transTypeService.selectByTransTypeId(carResource.getTransTypeId()));
    }

    /**
     * 更新车源信息
     * @param carResource
     */
    public void updateCarResource(CarResource carResource) {
        carResource.setLastUpdateTime(new Date());
        int rows = carResourceMapper.updateByPrimaryKeySelective(carResource);
        if (rows <= 0){
            throw new HyzgException(ExceptionEnums.CAR_RESOURCE_UPDATE_ERROR);
        }
    }


    // 根据Id删除车源信息
    public void deleteCarResourceById(Long id) {
        int rows = carResourceMapper.deleteByPrimaryKey(id);
        if (rows <= 0){
            throw new HyzgException(ExceptionEnums.PRO_RESOURCE_DELETE_ERROR);
        }
    }
}
