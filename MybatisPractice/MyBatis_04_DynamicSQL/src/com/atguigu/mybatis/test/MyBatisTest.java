package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapperDynamic;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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


}
