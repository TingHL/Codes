package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@SessionAttributes("msg")
public class OutputController {
    @RequestMapping("/handler01")
    public String handler01(Map<String,Object> map){
        map.put("msg","ÄãºÃ map");
        return "success";
    }

    @RequestMapping("/handler02")
    public String handler02(Model model){
        model.addAttribute("msg","ÄãºÃ model");
        return "success";
    }

    @RequestMapping("/handler03")
    public String handler03(ModelMap modelMap){
        modelMap.addAttribute("msg","ÄãºÃ ModelMap");
        return "success";
    }

    @RequestMapping("/handler04")
    public ModelAndView handler04(){
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("msg","hello  ModelAndView");
        return modelAndView;
    }
}
