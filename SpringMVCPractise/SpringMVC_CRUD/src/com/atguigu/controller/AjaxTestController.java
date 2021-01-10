package com.atguigu.controller;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.util.Collection;

@Controller
public class AjaxTestController {
    @Autowired
    EmployeeDao employeeDao;

    /**
     * RequestBody 请求体
     * 获取请求的请求体
     * @RequestBody接受请求体数据
     * 可以接受json数据，封装为对象
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("请求体"+body);
        return "success";
    }

    @RequestMapping("/test01")
    public String test01(@RequestBody String str){
        System.out.println("请求体："+str);
        return "success";
    }

    /**
     * 如果参数写HttpEntity<String> str
     * 比@RequestBody更强，可以获取请求头
     */
    @RequestMapping("/test02")
    public String test02(HttpEntity<String> str){
        System.out.println("请求体"+str);
        return "success";
    }


    //@ResponseBody jackson将返回的数据放在响应体 如果是对象，自动将对象转换为json格式；如果不是对象，显示在浏览器上
    @ResponseBody
    @RequestMapping("/getallajax")
    public Collection<Employee> ajaxGetAll(){
        Collection<Employee> all=employeeDao.getAll();
        return all;
    }

    /**
     * @ResponseBody 另外一种用法设置响应体、响应头、响应状态码
     */
    @ResponseBody
    @RequestMapping("/haha")
    public ResponseEntity<String> haha(){
        MultiValueMap<String,String> headers=new HttpHeaders();
        String body="<h1>success</h1>";
        headers.add("Set-Cookie","username=hahaha");
        return new ResponseEntity<String>(body,headers, HttpStatus.OK);
    }

    //SpringMVC文件下载
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request)throws Exception{
        //1.得到要下载的文件的流
        String location="";
        //找到要下载的文件的真实路径
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/scripts/jquery-3.5.0.min.js");
        FileInputStream is = new FileInputStream(realPath);

        byte[] tmp=new byte[is.available()];
        is.read();
        is.close();

        //2.将要下载的文件流返回
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Disposition","attachment;filename="+"jquery-3.5.0.min.js");
        return new ResponseEntity<byte[]>(tmp,httpHeaders,HttpStatus.OK);
    }

}
