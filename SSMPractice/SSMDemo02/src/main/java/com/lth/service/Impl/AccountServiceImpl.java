package com.lth.service.Impl;

import com.lth.dao.IAccountdao;
import com.lth.daomain.Account;
import com.lth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private IAccountdao iAccountdao;

    @Override
    public List<Account> findAll() {
        System.out.println("Service业务层：查询所有账户...");
        return iAccountdao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("Service业务层：保存账户...");
        iAccountdao.saveAccount(account);
    }
}
