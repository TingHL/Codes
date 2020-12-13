package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

//MyBatis支持借口与配置文件动态绑定
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void addEmp(Employee employee);
}
