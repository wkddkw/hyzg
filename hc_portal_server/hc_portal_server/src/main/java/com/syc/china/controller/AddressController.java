package com.syc.china.controller;


import com.syc.china.pojo.Address;
import com.syc.china.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 省市区三级联动查询
     */
    @GetMapping("queryAddress")
    public ResponseEntity<List<Address>> selectAddress(List<Integer> id){
       List<Address> address = addressService.selectAddress(id);
        return ResponseEntity.ok(address);
    }


}
