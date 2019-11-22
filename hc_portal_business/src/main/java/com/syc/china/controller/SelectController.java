package com.syc.china.controller;

import com.syc.china.pojo.*;
import com.syc.china.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SelectController {
    @Autowired
    private CarTypeService carTypeService;
    @Autowired
    private ProTypeService proTypeService;
    @Autowired
    private ProDetailTypeService proDetailTypeService;
    @Autowired
    private TransTypeService transTypeService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private PriceUnitService priceUnitService;


    @GetMapping("/select")
    public ResponseEntity<Map<String, List<Object>>> select(){
        List<CarType> carTypes = carTypeService.select();
        List<ProType> proTypes = proTypeService.select();
        List<ProDetailType> proDetailTypes = proDetailTypeService.select();
        List<TransType> transTypes = transTypeService.select();
        List<Unit> units = unitService.select();
        List<PriceUnit> priceUnits = priceUnitService.select();

        Map<String,List<Object>> map = new HashMap<>();
        map.put("carTypes", Collections.singletonList(carTypes));
        map.put("proTypes", Collections.singletonList(proTypes));
        map.put("proDetailTypes", Collections.singletonList(proDetailTypes));
        map.put("transTypes", Collections.singletonList(transTypes));
        map.put("units", Collections.singletonList(units));
        map.put("priceUnits", Collections.singletonList(priceUnits));

        return ResponseEntity.ok(map);
    }

}
