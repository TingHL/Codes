package com.lth.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //标记为SpringMVC Controller对象
@RequestMapping("/hello")  //处理请求地址映射的注解
// 用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径
// 用于方法上，表示在类的父路径下追加方法上注解中的地址将会访问到该方法。
public class HelloController {

    @RequestMapping("/hello")   //用在方法上 在父类路径下追加的方法上注解中的地址将会访问到该方法  即，访问/hello/hello
    @ResponseBody //@Responsebody注解表示该方法的返回的结果直接写入 HTTP 响应正文中，一般在异步获取数据时使用；
    public String hello(){
        return "hello";
    }
}
