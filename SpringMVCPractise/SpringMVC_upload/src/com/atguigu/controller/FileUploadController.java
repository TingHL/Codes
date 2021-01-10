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

    //单文件上传
    @RequestMapping("upload")
    public String upload(@RequestParam(value="username",required = false)String username, @RequestParam("headerimg") MultipartFile file, Model model) throws IOException {

        System.out.println("上传的文件的信息");
        //getName()获取jsp文件中的name属性
        System.out.println("文件项的名字"+file.getName());
        //getOriginalFilename()方法获取上传文件中的名字
        System.out.println("文件的名字"+file.getOriginalFilename());

        //文件保存
        try{
            file.transferTo(new File("F:\\下载\\uploadFiles\\"+file.getOriginalFilename()));
            model.addAttribute("msg","file upload success!");
        }catch (Exception e){
            model.addAttribute("msg","file upload failed");
        }

        return "forward:/index.jsp";
    }

    //多文件上传
    @RequestMapping("uploadFiles")
    public String upload(@RequestParam(value="username",required = false)String username, @RequestParam("headerimg") MultipartFile[] files, Model model) throws IOException {

        System.out.println("上传的文件的信息");
        //getName()获取jsp文件中的name属性

        for(MultipartFile file:files){
            if(!file.isEmpty()){
                System.out.println("文件项的名字"+file.getName());
                //getOriginalFilename()方法获取上传文件中的名字
                System.out.println("文件的名字"+file.getOriginalFilename());

                //文件保存
                try{
                    file.transferTo(new File("F:\\下载\\uploadFiles\\"+file.getOriginalFilename()));
                    model.addAttribute("msg","file upload success!");
                }catch (Exception e){
                    model.addAttribute("msg","file upload failed");
                }
            }
        }



        return "forward:/index.jsp";
    }
}
