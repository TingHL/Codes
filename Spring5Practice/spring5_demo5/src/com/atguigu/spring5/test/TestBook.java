package com.atguigu.spring5.test;

import com.atguigu.spring5.entity.Book;
import com.atguigu.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {
    @Test
    public void testJdbcTemplateAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService=context.getBean("bookService",BookService.class);

        Book book=new Book();
        book.setUserId("1");
        book.setUsername("Java");
        book.setUstatus("A");

        bookService.addBook(book);
    }

    @Test
    public void testJdbcTemplateUpdate(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService=context.getBean("bookService",BookService.class);

        Book book=new Book();
        book.setUserId("1");
        book.setUsername("Javaupup");
        book.setUstatus("AB");

        bookService.updateBook(book);
    }

    @Test
    public void testJdbcTemplateDelete(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        bookService.deleteBook("1");
    }

    @Test
    public void testJdbcTemplateSelect(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        System.out.println(bookService.findCount());
    }

    @Test
    public void testJdbcTemplateSelectOjbect(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        System.out.println(bookService.findOne("1"));
    }

    @Test
    public void testJdbcTemplateSelectAll(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        System.out.println(bookService.findAll());
    }

    @Test
    public void testJdbcTemplatebatchAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        List<Object[]> batchArgs=new ArrayList<>();
        Object[] o1={"3","CC","C"};
        Object[] o2={"4","C++","D"};
        Object[] o3={"5","COMPILE","CM"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchAdd(batchArgs);
    }

    @Test
    public void testJdbcTemplatebatchUpdate(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        List<Object[]> batchArgs=new ArrayList<>();
        Object[] o1={"CC Update","C","3"};
        Object[] o2={"C++ Update","D","4"};
        Object[] o3={"COMPILE Update","CM","5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchUpdate(batchArgs);
    }

    @Test
    public void testJdbcTemplatebatchDelete(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
        List<Object[]> batchArgs=new ArrayList<>();
        Object[] o1={"3"};
        Object[] o2={"4"};
        Object[] o3={"5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDelete(batchArgs);
    }

}
