package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "success";
    }

    @RequestMapping("handler01")
    public String handler01(){
        System.out.println("handler01");
        return "forward:/hello.jsp";
    }

    @RequestMapping("handler03")
    public String handler03(){
        System.out.println("handler03");
        return "redirect:/hello.jsp";
    }

    @RequestMapping("handler04")
    public String handler04(){
        return "redirect:/handler03";
    }
}
