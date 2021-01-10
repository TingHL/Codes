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
     * RequestBody ������
     * ��ȡ�����������
     * @RequestBody��������������
     * ���Խ���json���ݣ���װΪ����
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("������"+body);
        return "success";
    }

    @RequestMapping("/test01")
    public String test01(@RequestBody String str){
        System.out.println("�����壺"+str);
        return "success";
    }

    /**
     * �������дHttpEntity<String> str
     * ��@RequestBody��ǿ�����Ի�ȡ����ͷ
     */
    @RequestMapping("/test02")
    public String test02(HttpEntity<String> str){
        System.out.println("������"+str);
        return "success";
    }


    //@ResponseBody jackson�����ص����ݷ�����Ӧ�� ����Ƕ����Զ�������ת��Ϊjson��ʽ��������Ƕ�����ʾ���������
    @ResponseBody
    @RequestMapping("/getallajax")
    public Collection<Employee> ajaxGetAll(){
        Collection<Employee> all=employeeDao.getAll();
        return all;
    }

    /**
     * @ResponseBody ����һ���÷�������Ӧ�塢��Ӧͷ����Ӧ״̬��
     */
    @ResponseBody
    @RequestMapping("/haha")
    public ResponseEntity<String> haha(){
        MultiValueMap<String,String> headers=new HttpHeaders();
        String body="<h1>success</h1>";
        headers.add("Set-Cookie","username=hahaha");
        return new ResponseEntity<String>(body,headers, HttpStatus.OK);
    }

    //SpringMVC�ļ�����
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request)throws Exception{
        //1.�õ�Ҫ���ص��ļ�����
        String location="";
        //�ҵ�Ҫ���ص��ļ�����ʵ·��
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/scripts/jquery-3.5.0.min.js");
        FileInputStream is = new FileInputStream(realPath);

        byte[] tmp=new byte[is.available()];
        is.read();
        is.close();

        //2.��Ҫ���ص��ļ�������
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Disposition","attachment;filename="+"jquery-3.5.0.min.js");
        return new ResponseEntity<byte[]>(tmp,httpHeaders,HttpStatus.OK);
    }

}
