package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ����SpringMVC ����һ�������� ���Դ�������
 * @Controller����ʶ�ĸ�����ǿ�����
 */
@Controller
public class MyFirstController {

    /**
     * / ����ӵ�ǰ��Ŀ�¿�ʼ������ǰ��Ŀ�µ�hello����
     */
    @RequestMapping("/hello")
    public String myfirstRequest(){
        System.out.println("Hello �����յ��� ���ڴ�����");
        //�����ַ��� ��ʾ�µĵ�ַ  �µ�ҳ���ַ  ת������
        return "/WEB-INF/pages/success.jsp";  //���õ���ͼ���������Զ�ƴ��ǰ׺�ͺ�׺  ��ǰ��Ŀ����/hello �ᱨ��
    }

    @RequestMapping("/helloworld")
    public String helloWordRequest(){
        System.out.println("Hello World �����յ��� ���ڴ�����");
        return "success";
    }
}
