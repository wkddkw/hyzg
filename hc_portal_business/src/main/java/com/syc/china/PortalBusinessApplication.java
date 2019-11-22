package com.syc.china;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.syc.china.mapper")
public class PortalBusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortalBusinessApplication.class,args);
    }
}
