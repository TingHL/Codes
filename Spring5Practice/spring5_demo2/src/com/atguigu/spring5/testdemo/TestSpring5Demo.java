package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.autowire.Emp;
import com.atguigu.spring5.bean.Orders;
import com.atguigu.spring5.collectiontype.Book;
import com.atguigu.spring5.collectiontype.Course;
import com.atguigu.spring5.collectiontype.Stu;
import com.atguigu.spring5.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5Demo {
    @Test
    public void testCollection(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu=context.getBean("stu",Stu.class);
        stu.test();
    }

    @Test
    public void testCollection2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        Book book=context.getBean("book",Book.class);
        book.test();
    }

    @Test
    public void test3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean3.xml");
        Course course=context.getBean("myBean",Course.class);
        System.out.println(course);
    }

    @Test
    public void testBean3(){
//        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean4.xml");
        ApplicationContext context=new ClassPathXmlApplicationContext("bean4.xml");
        Orders orders=context.getBean("orders", Orders.class);
        System.out.println("第四步 获取创建bean实例的对象");
        System.out.println(orders);

        //手动 bean实例销毁
        //ApplicationContext 没有实现close方法 其子类有实现的接口所以进行类型的转换
//        context.close();
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void test4(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp=context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
