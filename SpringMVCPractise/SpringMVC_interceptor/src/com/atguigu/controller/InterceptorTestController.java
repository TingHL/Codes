package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorTestController {
    @RequestMapping("/testhandler")
    public String testhandler(){
        System.out.println("test01");
        return "success";
    }
}
