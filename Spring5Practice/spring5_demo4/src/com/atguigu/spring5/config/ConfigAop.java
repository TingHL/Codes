package com.atguigu.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration     //配置类
@ComponentScan(basePackages = {"com.atguigu"})    //开启组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)  //开启AspectJ 代理对象
public class ConfigAop {
}
