package com.atguigu.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void addMoney() {
        String sql="update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql,100,"mary");
    }

    //lucy转账100
    @Override
    public void reduceMoney() {
        String sql="update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql,100,"lucy");
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
}
