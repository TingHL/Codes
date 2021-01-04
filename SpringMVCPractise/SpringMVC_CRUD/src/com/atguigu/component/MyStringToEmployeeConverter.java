package com.atguigu.component;


import com.atguigu.dao.DepartmentDao;
import com.atguigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *入参：两个泛型 S：Source --> T：Target
 */
public class MyStringToEmployeeConverter implements Converter<String, Employee>{

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public Employee convert(String s) {
        System.out.println("页面提交的将要转换的字符串"+s);

        Employee employee=new Employee();
        if(s.contains("-")){
            String[] split = s.split("-");
            employee.setLastName(split[0]);
            employee.setEmail(split[1]);
            employee.setGender(Integer.parseInt(split[2]));
            employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(split[3])));
        }
        return employee;
    }
}
