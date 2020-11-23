package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * User class corresponding to Table User in mysql
 * The statement create talbe user:
 * CREATE TABLE `user` (
 * `id` int(11) NOT NULL auto_increment,
 * `username` varchar(32) NOT NULL COMMENT '用户名称',
 * `birthday` datetime default NULL COMMENT '生日',
 * `sex` char(1) default NULL COMMENT '性别',
 * `address` varchar(256) default NULL COMMENT '地址',
 * PRIMARY KEY  (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
