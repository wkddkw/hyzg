package com.syc.china;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置中心服务
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }


//    Realm{
//        //认证
//        SimpleAuthenticatinoInfo doAuthentication(token){
//                //根据用户名查询有没有对应的用户
//                //user对象
//
//                SimpleAuthenticatinoInfo info=new SimpleAuthenticatinoInfo(user,password,getName());
//                return info;
//        }
//
//        //授权
//    }

    //subject.isAuthenticated();
    //User user=subject.getPrincipal();

}
