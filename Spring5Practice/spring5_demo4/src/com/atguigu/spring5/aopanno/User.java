package com.atguigu.spring5.aopanno;

import org.springframework.stereotype.Component;

//被增强类
@Component
public class User {

    //    前置通知
    public void add(){
        System.out.println("add ...");
    }
}
