package com.lth.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //标注类是一个springboot应用
public class HelloworldApplication {

    public static void main(String[] args) {
        //将Springboot应用启动
        SpringApplication.run(HelloworldApplication.class, args);
    }

}
