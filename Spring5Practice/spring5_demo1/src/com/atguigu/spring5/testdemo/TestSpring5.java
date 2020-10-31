package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.Orders;
import com.atguigu.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class TestSpring5 {

    @Test  //注解表明这是个测试方法  测试方法必须是public  void，即公共、无返回数据。可以抛出异常。
    public void testAdd(){
        //加载配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        //获取创建的对象
        User user=context.getBean("user",User.class);
        user.add();
    }


    @Test
    public void testBook1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Book book=context.getBean("book", Book.class);
        book.testDemo();
    }

    @Test
    public void testOrders(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Orders orders=context.getBean("orders", Orders.class);
        orders.ordersTest();
    }
}
