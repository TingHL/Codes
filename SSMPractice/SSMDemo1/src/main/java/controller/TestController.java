package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {

    @RequestMapping(path = "testssm",method = {RequestMethod.POST},produces="text/html;charset=UTF-8")
    @ResponseBody
    public String testDemo(String sendmessage, HttpServletResponse response) {
        System.out.println("收到"+sendmessage);
        String s = "hello SSM";
        return sendmessage+"后台添加："+s;
    }


}
