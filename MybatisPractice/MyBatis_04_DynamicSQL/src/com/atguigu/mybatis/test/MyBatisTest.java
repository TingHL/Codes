package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Department;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapperDynamic;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.junit.Test;

public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource="mybatis-config.xml";
        InputStream inputStream=Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    //测试if where标签
    @Test
    public void TestDynamicSQL() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Employee employee=new Employee(null,"%e%",null,null);

        try{
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);

            List<Employee> emps = mapper.getEmpsByConditionIf(employee);
            for(Employee emp:emps){
                System.out.println(emp);
            }
        }finally {
            sqlSession.close();
        }
    }

    //测试trim标签
    @Test
    public void TestDynamicSQLTrim() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Employee employee=new Employee(null,"%e%",null,null);
        try{
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);

            List<Employee> emps = mapper.getEmpsByConditionTrim(employee);
            for(Employee emp:emps){
                System.out.println(emp);
            }
        }finally {
            sqlSession.close();
        }
    }

    //测试when标签
    @Test
    public void TestDynamicSQLChoose() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Employee employee=new Employee(1,"%e%","jerry@atguigu.com",null);
        try{
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);

            List<Employee> emps = mapper.getEmpsByConditionChoose(employee);
            for(Employee emp:emps){
                System.out.println(emp);
            }
        }finally {
            sqlSession.close();
        }
    }

    //遍历集合
    //测试update更新操作 针对方法updateEmp
    @Test
    public void TestDynamicSQLUpdateEmp() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //Employee employee=new Employee(1,"admin",null,null);
        try{
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
           // mapper.updateEmp(employee);
            List<Employee> list=mapper.getEmpsByConditionForeach(Arrays.asList(1,2,3,4));
            for(Employee employee1:list)
                System.out.println(employee1);

            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }


    //batch insert 批量插入测试
    @Test
    public void TestDynamicSQLBatchInsert() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            // mapper.updateEmp(employee);
            List<Employee> list=new ArrayList<>();
            list.add(new Employee(null,"smith","smith@atguigu.com","1",new Department(1)));
            list.add(new Employee(null,"allen","allen@atguigu.com","0",new Department(2)));
            mapper.addEmps(list);

            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

}
