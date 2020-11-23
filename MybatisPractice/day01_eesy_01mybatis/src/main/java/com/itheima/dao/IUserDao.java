package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

//用户 持久层接口 Dao Data Access Object 数据存取对象
public interface IUserDao {
    //查询所有操作
    List<User> findAll();
}
