package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyViewResovlerController {
    @RequestMapping("handlerplus")
    public String handlerplus(Model model){
        List<String> vname=new ArrayList<>();
        List<String> imgName=new ArrayList<>();

        vname.add("video1");
        vname.add("video2");
        vname.add("video3");
        imgName.add("img1");
        imgName.add("img2");

        model.addAttribute("video",vname);
        model.addAttribute("imgs",imgName);

        return "meinv:/gaoqing";
    }
}
