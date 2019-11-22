package com.syc.china;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.syc.china.mapper")
public class PortalServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalServerApplication.class, args);
    }

}
