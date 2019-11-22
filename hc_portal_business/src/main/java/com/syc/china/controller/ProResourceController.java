package com.syc.china.controller;

import com.hyzg.common.pojo.PageResult;
import com.syc.china.pojo.ProKey;
import com.syc.china.pojo.ProResource;
import com.syc.china.service.ProResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProResourceController {

    @Autowired
    private ProResourceService proResourceService;

    /**
     * 发布货源信息
     * @param proResource
     * @return
     */
    @PostMapping("/pro/send")
    public ResponseEntity<Void> sendProResource(ProResource proResource){
        proResourceService.insertProResource(proResource);
        return ResponseEntity.ok(null);
    }

    /**
     * 分页查询货源信息
     * @param proKey 查询条件
     * @param page  第几页
     * @param rows  每页行数
     * @return
     */
    @GetMapping("/pro/page")
    public ResponseEntity<PageResult<ProResource>> queryProResourceByPage(
        ProKey proKey,
        @RequestParam(value = "page",defaultValue = "1") Integer page,
        @RequestParam(value = "rows",defaultValue = "5") Integer rows
    ){
        PageResult<ProResource> pageResult = proResourceService.queryProResourceByPage (page,rows,proKey);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查询货源信息
     * @param id
     * @return
     */
    @GetMapping("/pro/queryOne/{id}")
    public ResponseEntity<ProResource> queryProResourceById(@PathVariable("id") Long id){
        ProResource proResource = proResourceService.queryProResourceById(id);
        return ResponseEntity.ok(proResource);
    }

    /**
     * 更新货源信息
     * @param proResource
     * @return
     */
    @PutMapping("/pro/update")
    public ResponseEntity<Void> updateProResource(ProResource proResource){
        proResourceService.updateProResource(proResource);
        return ResponseEntity.ok(null);
    }

    /**
     * 根据id删除货源信息
     * @param id
     * @return
     */
    @DeleteMapping("/pro/delete/{id}")
    public ResponseEntity<Void> deleteProResource(@PathVariable("id")Long id){
        proResourceService.deleteProResourceById(id);
        return ResponseEntity.ok(null);
    }
}
