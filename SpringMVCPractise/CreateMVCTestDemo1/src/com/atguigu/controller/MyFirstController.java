package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 告诉SpringMVC 这是一个处理器 可以处理请求
 * @Controller：标识哪个组件是控制器
 */
@Controller
public class MyFirstController {

    /**
     * / 代表从当前项目下开始，处理当前项目下的hello请求
     */
    @RequestMapping("/hello")
    public String myfirstRequest(){
        System.out.println("Hello 请求收到了 正在处理中");
        //返回字符串 表示新的地址  新的页面地址  转发操作
        return "/WEB-INF/pages/success.jsp";  //配置的视图解析器会自动拼接前缀和后缀  当前项目请求/hello 会报错
    }

    @RequestMapping("/helloworld")
    public String helloWordRequest(){
        System.out.println("Hello World 请求收到了 正在处理中");
        return "success";
    }
}
