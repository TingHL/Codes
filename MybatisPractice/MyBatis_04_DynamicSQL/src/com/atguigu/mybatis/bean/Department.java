package com.atguigu.mybatis.bean;

import java.util.List;

public class Department {
    private Integer id;
    private String departmentName;
    private List<Employee> emps;  //改部门下的所有员工

    public Department(){
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Department(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
