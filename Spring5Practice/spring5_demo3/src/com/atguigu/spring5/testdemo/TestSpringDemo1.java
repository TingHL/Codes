package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.testdemo.config.SpringConfig;
import com.atguigu.spring5.testdemo.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDemo1 {
    @Test
    public void testService(){
//        加载配置类
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService=context.getBean("userService",UserService.class);
        userService.add();
    }
}
