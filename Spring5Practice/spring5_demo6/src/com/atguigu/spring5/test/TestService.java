package com.atguigu.spring5.test;

import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

public class TestService {
    @Test
    public void testAccount(){

        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService=context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
