package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    //���ļ��ϴ�
    @RequestMapping("upload")
    public String upload(@RequestParam(value="username",required = false)String username, @RequestParam("headerimg") MultipartFile file, Model model) throws IOException {

        System.out.println("�ϴ����ļ�����Ϣ");
        //getName()��ȡjsp�ļ��е�name����
        System.out.println("�ļ��������"+file.getName());
        //getOriginalFilename()������ȡ�ϴ��ļ��е�����
        System.out.println("�ļ�������"+file.getOriginalFilename());

        //�ļ�����
        try{
            file.transferTo(new File("F:\\����\\uploadFiles\\"+file.getOriginalFilename()));
            model.addAttribute("msg","file upload success!");
        }catch (Exception e){
            model.addAttribute("msg","file upload failed");
        }

        return "forward:/index.jsp";
    }

    //���ļ��ϴ�
    @RequestMapping("uploadFiles")
    public String upload(@RequestParam(value="username",required = false)String username, @RequestParam("headerimg") MultipartFile[] files, Model model) throws IOException {

        System.out.println("�ϴ����ļ�����Ϣ");
        //getName()��ȡjsp�ļ��е�name����

        for(MultipartFile file:files){
            if(!file.isEmpty()){
                System.out.println("�ļ��������"+file.getName());
                //getOriginalFilename()������ȡ�ϴ��ļ��е�����
                System.out.println("�ļ�������"+file.getOriginalFilename());

                //�ļ�����
                try{
                    file.transferTo(new File("F:\\����\\uploadFiles\\"+file.getOriginalFilename()));
                    model.addAttribute("msg","file upload success!");
                }catch (Exception e){
                    model.addAttribute("msg","file upload failed");
                }
            }
        }



        return "forward:/index.jsp";
    }
}
