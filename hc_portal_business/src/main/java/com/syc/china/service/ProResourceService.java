package com.syc.china.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyzg.common.enums.ExceptionEnums;
import com.hyzg.common.exception.HyzgException;
import com.hyzg.common.pojo.PageResult;
import com.syc.china.mapper.ProResourceMapper;
import com.syc.china.pojo.ProKey;
import com.syc.china.pojo.ProResource;
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
    private ProTypeService proTypeService;
    @Autowired
    private PriceUnitService priceUnitService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private ProDetailTypeService proDetailTypeService;
    @Autowired
    private TransTypeService transTypeService;

    // 发布货源信息
    public void insertProResource(ProResource proResource) {
        proResource.setCreateTime(new Date());
        proResource.setLastUpdateTime(new Date());
        int rows = proResourceMapper.insert(proResource);
        if (rows <= 0){
            throw new HyzgException(ExceptionEnums.PRO_RESOURCE_SEND_ERROR);
        }
    }

    // 分页查询货源信息
    public PageResult<ProResource> queryProResourceByPage(Integer page, Integer rows, ProKey proKey) {
        // 设置分页，每页最多100条记录
        PageHelper.startPage(page,Math.min(rows,100));

        Example example = new Example(ProResource.class);
        Example.Criteria criteria = example.createCriteria();
        
        // 过滤
        if (proKey != null){
            if (StringUtils.isNotBlank(proKey.getStartProvince())){
                criteria.andEqualTo("startProvince",proKey.getStartProvince());
            }
            if (StringUtils.isNotBlank(proKey.getStartCity())){
                criteria.andEqualTo("startCity",proKey.getStartCity());
            }
            if (StringUtils.isNotBlank(proKey.getStartArea())){
                criteria.andEqualTo("startArea",proKey.getStartArea());
            }
            if (StringUtils.isNotBlank(proKey.getEndProvince())){
                criteria.andEqualTo("endProvince",proKey.getEndProvince());
            }
            if (StringUtils.isNotBlank(proKey.getEndCity())){
                criteria.andEqualTo("endCity",proKey.getEndCity());
            }
            if (StringUtils.isNotBlank(proKey.getEndArea())){
                criteria.andEqualTo("endArea",proKey.getEndArea());
            }
            if (StringUtils.isNotBlank(proKey.getProName())){
                criteria.andEqualTo("proName",proKey.getProName());
            }
            if (proKey.getCarTypeId() != null){
                criteria.andEqualTo("carTypeId",proKey.getCarTypeId());
            }
            if (proKey.getTransTypeId() != null){
                criteria.andEqualTo("transTypeId",proKey.getTransTypeId());
            }
            if (proKey.getProTypeId() != null){
                criteria.andEqualTo("proTypeId",proKey.getProTypeId());
            }
            if (proKey.getProDetailTypeId() != null){
                criteria.andEqualTo("proDetailTypeId",proKey.getProDetailTypeId());
            }
            if (proKey.getNum() != null){
                criteria.andEqualTo("num",proKey.getNum());
            }
            if (proKey.getUnitId() != null){
                criteria.andEqualTo("unitId",proKey.getUnitId());
            }
        }

        //默认排序
        example.setOrderByClause("last_update_time desc");

        // 查询
        List<ProResource> proResources = proResourceMapper.selectByExample(example);
        for (ProResource pr : proResources){
            setProResourceData(pr);
        }

        PageInfo<ProResource> pageInfo = new PageInfo<>(proResources);

        // 封装分页信息
        PageResult<ProResource> result = new PageResult<>();
        result.setTotalPage((long) pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setItems(proResources);

        return result;
    }

    // 根据id查询货源信息
    public ProResource queryProResourceById(Long id) {
        ProResource proResource = proResourceMapper.selectByPrimaryKey(id);
        if (proResource == null){
            throw new HyzgException(ExceptionEnums.PRO_RESOURCE_IS_EMPTY);
        }
        setProResourceData(proResource);
        return proResource;
    }

    /**
     * 抽取出来用来填充，用户要看的数据
     * @param proResource
     */
    private void setProResourceData(ProResource proResource){
        proResource.setProType(proTypeService.selectByProTypeId(proResource.getProTypeId()));
        proResource.setPriceUnit(priceUnitService.selectByPriceUnitId(proResource.getPriceUnitId()));
        proResource.setUnit(unitService.selectByUnitId(proResource.getUnitId()));
        proResource.setTransType(transTypeService.selectByTransTypeId(proResource.getTransTypeId()));
        proResource.setProDetailType(proDetailTypeService.selectByProDetailTypeId(proResource.getProDetailTypeId()));
    }

    // 更新货源信息
    public void updateProResource(ProResource proResource) {
        int rows = proResourceMapper.updateByPrimaryKeySelective(proResource);
        if (rows <= 0){
            throw new HyzgException(ExceptionEnums.CAR_RESOURCE_UPDATE_ERROR);
        }
    }

    // 根据id删除货源信息
    public void deleteProResourceById(Long id) {
        int rows = proResourceMapper.deleteByPrimaryKey(id);
        if (rows <= 0){
            throw new HyzgException(ExceptionEnums.PRO_RESOURCE_DELETE_ERROR);
        }
    }
}
