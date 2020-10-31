package com.atguigu.spring5.bean;

//部门类
public class Department {
    private  String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
