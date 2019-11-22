package com.syc.china.controller;


import com.hyzg.common.pojo.PageResult;
import com.syc.china.pojo.CarKey;
import com.syc.china.pojo.CarResource;
import com.syc.china.service.CarResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CarResourceController {
    @Autowired
    private CarResourceService carResourceService;

    /**
     * 发布车源
     * @param carResource
     * @return
     */
    @PostMapping("/car/send")
    public ResponseEntity<Void> sendCarResource(CarResource carResource){
        carResourceService.insertCarResource(carResource);
        return ResponseEntity.ok(null);
    }

    /**
     * 分页查询车源信息
     * @param carKey 查询条件
     * @param page   第几页
     * @param rows   每页行数
     * @return
     */
    @GetMapping("/car/page")
    public ResponseEntity<PageResult<CarResource>> queryCarResourceByPage(
            CarKey carKey,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows
    ){

        PageResult<CarResource> pageResult = carResourceService.queryCarResourceByPage(page,rows,carKey);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查询车源信息
     * @param id
     * @return
     */
    @GetMapping("/car/queryOne/{id}")
    public ResponseEntity<CarResource> queryCarResourceById(@PathVariable Long id){
        CarResource carResource = carResourceService.queryCarResourceById(id);
        return ResponseEntity.ok(carResource);
    }

    /**
     * 更新车源信息
     * @param carResource
     * @return
     */
    @PutMapping("/car/update")
    public ResponseEntity<Void> updateCarResource(CarResource carResource){
        carResourceService.updateCarResource(carResource);
        return ResponseEntity.ok(null);
    }

    /**
     * 根据车源信息Id删除
     * @param id
     * @return
     */
    @DeleteMapping("/car/delete/{id}")
    public ResponseEntity<Void> deleteCarResourceById(@PathVariable("id") Long id){
        carResourceService.deleteCarResourceById(id);
        return ResponseEntity.ok(null);
    }

}
