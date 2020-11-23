package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;

public class MyBatisTest {

    /**
     * 1.根据xml配置文件（全局配置文件）创建一个sqlSessionFactory 对象
     * 2.
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        //配置文件
        String resource = "mybatis-config.xml";
        //配置文件的流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取sqlSession实例，能直接执行已经映射的sql语句
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //selectOne
        //第一个参数：唯一标识，通常使用namespace+id来标识
        //第二个参数：sql使用的参数
        try{
            //select * from tbl_employee where id = #{id} 类中的lastName与数据库中的last_name不对应 查询出来的结果lastName为null
            Employee employee=sqlSession.selectOne("com.atguigu.mybatis.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);

            //select id,last_name lastName, email,gender from tbl_employee where id=#{id} 通过查询语句别名的方式，将类中的lastName与数据库中的last_name相对应
            employee=sqlSession.selectOne("com.atguigu.mybatis.EmployeeMapper.selectEmpNickName", 1);
            System.out.println(employee);
        }finally {
            sqlSession.close();
        }
    }
}
