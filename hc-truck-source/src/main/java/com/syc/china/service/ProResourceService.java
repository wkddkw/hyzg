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
public class ProResourceService {
    @Autowired
    private ProResourceMapper proResourceMapper;
    @Autowired
    private ProTypeMapper proTypeMapper;
    @Autowired
    private ProDetailTypeMapper proDetailTypeMapper;
    @Autowired
    private UnitMapper unitMapper;
    @Autowired
    private TransTypeMapper transTypeMapper;
    @Autowired
    private PriceUnitMapper priceUnitMapper;

    public PageResult<ProResource> queryProResourceByPageAndSort(Integer page, Integer size, String sortBy, String key) {
        PageHelper.startPage(page,size);
        Example example=new Example(ProResource.class);
        //设置模糊查询
        if(StringUtils.isNotBlank(key)){
            example.createCriteria().andLike("startCity","%"+key+"%").orEqualTo("startCity",key);
        }
        //默认排序
        example.setOrderByClause("last_update_time desc");
        List<ProResource> proResources = proResourceMapper.selectByExample(example);
        for (ProResource proResource:proResources){
            Integer proTypeId = proResource.getProTypeId();
            ProType proType = proTypeMapper.selectByPrimaryKey(proTypeId);
            proResource.setProType(proType.getProType());

            Integer proDetailTypeId = proResource.getProDetailTypeId();
            ProDetailType proDetailType = proDetailTypeMapper.selectByPrimaryKey(proDetailTypeId);
            proResource.setProDetailType(proDetailType.getProDetailType());

            Integer unitId = proResource.getUnitId();
            Unit unit = unitMapper.selectByPrimaryKey(unitId);
            proResource.setUnit(unit.getUnit());

            Integer transTypeId = proResource.getTransTypeId();
            TransType transType = transTypeMapper.selectByPrimaryKey(transTypeId);
            proResource.setTransType(transType.getTransType());

            Integer priceUnitId = proResource.getPriceUnitId();
            PriceUnit priceUnit = priceUnitMapper.selectByPrimaryKey(priceUnitId);
            proResource.setPriceUnit(priceUnit.getPriceUnit());
        }
        PageInfo<ProResource>pageInfo=new PageInfo<>(proResources);
        //封装分页对象
        PageResult<ProResource>result=new PageResult<>();
        result.setItems(proResources);
        result.setTotal(pageInfo.getTotal());
        result.setTotalPage(Long.valueOf(pageInfo.getPages()));
        return result;
    }


    public void saveProResource(ProResource proResource) {
        if (proResource.getStartProvince()!=null&&proResource.getStartCity()!=null&&proResource.getStartArea()!=null
                &&proResource.getEndProvince()!=null&&proResource.getEndCity()!=null&&proResource.getEndArea()!=null
                &&proResource.getProTypeId()!=null&&proResource.getName()!=null&&proResource.getTel()!=null
        ){
            if(proResource.getEmail()==null)
                proResource.setEmail("无");
            if(proResource.getQq()==null)
                proResource.setQq("无");
            proResource.setCreateTime(new Date());
            proResource.setLastUpdateTime(new Date());
            proResourceMapper.insert(proResource);
        }
        else
            throw new HyzgException(ExceptionEnums.PRO_RESOURCE_SEND_ERROR);
    }

    public void deleteProResource(Long id) {
        proResourceMapper.deleteByPrimaryKey(id);
    }

    public void updateProResource(ProResource proResource) {
        proResource.setLastUpdateTime(new Date());
        proResourceMapper.updateByPrimaryKey(proResource);
    }
}
