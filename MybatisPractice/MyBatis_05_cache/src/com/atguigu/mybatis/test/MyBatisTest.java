package com.atguigu.mybatis.test;

import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource="mybatis-config.xml";
        InputStream inputStream=Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 两级缓存：
     * 一级缓存（本地缓存）：
     *      与数据库同一次会话期间查询到的数据会放在本地缓存中
     *      以后如果需要获取相同的数据，直接从缓存中拿，没有必要再去查询数据库
     * 二级缓存（全局缓存）：
     * @throws IOException
     */
    @Test
    public void TestCacheFirstLevel() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession1=sqlSessionFactory.openSession();

        try{
            EmployeeMapper mapper1=sqlSession1.getMapper(EmployeeMapper.class);
            Employee emp02=mapper1.getEmpById(2);

            sqlSession1.clearCache();
            Employee emp03=mapper1.getEmpById(2);

            System.out.println(emp03==emp02);

            sqlSession1.commit();
        }finally {
            sqlSession1.close();
        }
    }

    @Test
    public void TestCacheSecondLevel() throws  IOException{
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession1=sqlSessionFactory.openSession();
        SqlSession sqlSession2=sqlSessionFactory.openSession();

        try{
            EmployeeMapper mapper1=sqlSession1.getMapper(EmployeeMapper.class);
            EmployeeMapper mapper2=sqlSession2.getMapper(EmployeeMapper.class);

            Employee emp01=mapper1.getEmpById(2);
            sqlSession1.clearCache();
            sqlSession1.close();

            Employee emp02=mapper2.getEmpById(2);
            sqlSession2.close();

            System.out.println(emp01==emp02);

        }finally {
            sqlSession1.close();
        }
    }
}
