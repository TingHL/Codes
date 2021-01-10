package com.lth.com.lth.controller;

import com.lth.daomain.Account;
import com.lth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/findAll")
    public String findAll(Model model){
        System.out.println("Controller表现层：查询所有账户...");
        List<Account> list=accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/account/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
