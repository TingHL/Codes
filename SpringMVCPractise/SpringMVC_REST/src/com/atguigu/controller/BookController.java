package com.atguigu.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    @RequestMapping(value="/book/{bid}",method = RequestMethod.POST)
    public String addBook(@PathVariable("bid")String id){
        System.out.println("增加图书");
        return "success";
    }

    @RequestMapping(value="/book/{bid}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bid")String id){
        System.out.println("删除图书"+id);
        return "success";
    }

    @RequestMapping(value="/book/{bid}",method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bid")String id){
        System.out.println("更新图书"+id);
        return "success";
    }

    @RequestMapping(value = "/book/{bid}",method = RequestMethod.GET)
    public String findBook(@PathVariable("bid")String id){
        System.out.println("查询图书"+id);
        return "success";
    }
}
