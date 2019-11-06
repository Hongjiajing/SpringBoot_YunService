package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.dao")//自动创建dao实现
public class application {
    public static void main(String[] args) {
        SpringApplication.run(application.class,args);
    }

}
