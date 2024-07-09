package com.gy.mapapitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapApiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapApiTestApplication.class, args);
        System.out.println("服务器启动成功");
    }

}
