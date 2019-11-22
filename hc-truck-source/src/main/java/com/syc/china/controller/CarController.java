package com.syc.china.controller;


import com.hyzg.common.pojo.PageResult;
import com.syc.china.pojo.CarResource;
import com.syc.china.service.CarResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car")
public class CarController {

    @Autowired
    private CarResourceService carResourceService;
    @GetMapping("/query")
    public ResponseEntity<PageResult<CarResource>> queryCarResourceByPage(
        @RequestParam(value = "page",defaultValue = "1")Integer page,
        @RequestParam(value = "size",defaultValue = "5")Integer size,
        @RequestParam(value = "sortBy",defaultValue = "id",required = false)String sortBy,
        @RequestParam(value = "key",required = false)String key
    ){
        PageResult<CarResource>result=carResourceService.queryCarResourceByPageAndSort(page,size,sortBy,key);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/save")
    public ResponseEntity<Void>saveCarResource(CarResource carResource){
        carResourceService.saveCarResource(carResource);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void>deleteCarResource(@RequestParam(value = "id") Long id){
        carResourceService.deleteCarResource(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/update")
    public ResponseEntity<Void>updateCarResource(CarResource carResource){
        carResourceService.updateCarResource(carResource);
        return ResponseEntity.ok(null);
    }
}
