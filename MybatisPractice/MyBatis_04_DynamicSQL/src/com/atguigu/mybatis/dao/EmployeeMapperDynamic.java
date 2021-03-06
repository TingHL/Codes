package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamic {

    //携带了那些字段查询条件就带上这个字段的值
    public List<Employee> getEmpsByConditionIf(Employee e);

    //根据trim标签判断 携带了那些字段查询条件就带上这个字段的值
    public List<Employee> getEmpsByConditionTrim(Employee employee);

    //根据某一个属性值进行查询
    public List<Employee> getEmpsByConditionChoose(Employee employee);

    //员工更新方法 哪些字段具有非null属性则进行改属性更新
    public void updateEmp(Employee employee);

    //传入多个id查询数据
    public List<Employee> getEmpsByConditionForeach(@Param("ids") List<Integer> ids);

    //传入多个Employee进行保存
    public void addEmps(@Param("emps") List<Employee> emps);

    //测试内置参数
    public List<Employee> getEmpsTestInnerParameter(Employee employee);

}
