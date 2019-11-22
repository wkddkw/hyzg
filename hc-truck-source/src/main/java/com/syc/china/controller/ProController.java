package com.syc.china.controller;


import com.hyzg.common.pojo.PageResult;
import com.syc.china.pojo.ProResource;
import com.syc.china.service.ProResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pro")
public class ProController {
    @Autowired
    private ProResourceService proResourceService;

    @GetMapping("/query")
    public ResponseEntity<PageResult<ProResource>>queryProResourceByPage(
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "size",defaultValue = "5")Integer size,
            @RequestParam(value = "key",required = false)String key,
            @RequestParam(value = "sortBy",defaultValue = "id",required = false)String sortBy
    ){
            PageResult<ProResource>pageResult=proResourceService.queryProResourceByPageAndSort(page,size,sortBy,key);
            return ResponseEntity.ok(pageResult);
    }

    @PostMapping("/save")
    public ResponseEntity<Void>ProResource(ProResource proResource){
        proResourceService.saveProResource(proResource);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void>deleteProResource(@RequestParam(value = "id") Long id){
        proResourceService.deleteProResource(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/update")
    public ResponseEntity<Void>updateProResource(ProResource proResource){
        proResourceService.updateProResource(proResource);
        return ResponseEntity.ok(null);
    }
}

