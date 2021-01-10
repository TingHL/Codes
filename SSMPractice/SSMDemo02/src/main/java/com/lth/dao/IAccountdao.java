package com.lth.dao;

import com.lth.daomain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

//IAccountdao并没有实体 通过mybatis进行管理
@Repository
public interface IAccountdao {
    //查询所有账户
    @Select("select * from account")
    public List<Account> findAll();

    //保存账户信息
    @Select("insert into account(name,money) value(#{name},#{money})")
    public void saveAccount(Account account);
}
