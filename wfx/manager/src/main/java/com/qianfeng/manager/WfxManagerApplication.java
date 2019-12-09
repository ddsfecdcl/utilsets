package com.qianfeng.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.qianfeng.manager.*.dao")
public class WfxManagerApplication {
    public static void main(String[] args) {
           SpringApplication.run(WfxManagerApplication.class, args);


    }
}
