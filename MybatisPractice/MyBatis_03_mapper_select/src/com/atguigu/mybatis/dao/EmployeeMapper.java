package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//MyBatis支持借口与配置文件动态绑定
public interface EmployeeMapper {

    public List<Employee> getEmpsByLastNameLike(String lastName);

    //返回一条记录的map：key就是列名（数据库中的字段名），值就是对应的值
    public Map<String,Object> getEmpByIdReturnMap(Integer id);

    //多条记录封装成一个map：Map<Integer,Employee> 健是这条记录的主键，值是封装后的javaBean
    //@MapKey 注解标识封装这个map时候，使用哪个属性作为map的主键
    @MapKey("id")
    public Map<Integer,Employee> getEmpByLastNameLikeReturnMap(String lastName);

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
