package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

//MyBatis支持借口与配置文件动态绑定
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public Employee getEmployeeByIdAndLastName(Integer id,String lastName);
    public Employee getEmployeeByIdAndLastNameTwo(@Param("id") Integer id, @Param("lastName") String lastName);

    //map方法测试
    public Employee getEmpByMap(Map<String,Object> map);

    public void addEmp(Employee employee);

//    public void updateEmp(Employee employee);
    //修改映射文件中的方法返回类型，定义返回类型为boolean类型
    public boolean updateEmp(Employee employee);

    public void deleteEmpById(Integer id);

}
