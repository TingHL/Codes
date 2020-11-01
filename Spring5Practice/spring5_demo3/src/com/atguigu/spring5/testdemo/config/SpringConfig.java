package com.atguigu.spring5.testdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //将当前类作为配置类，代替XML配置文件
@ComponentScan(basePackages = {"com.atguigu"})  //注解表示扫描的部分
public class SpringConfig {
}
