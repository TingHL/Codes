package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;

public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource="mybatis-config.xml";
        InputStream inputStream=Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void Test02() throws IOException {
        //1.获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();

        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            //基于注解版本
            EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
            Employee employee=mapper.getEmpById(1);

            System.out.println(mapper.getClass());  //class com.sun.proxy.$Proxy6
            System.out.println(employee);
        }finally {
            sqlSession.close();
        }
    }


    /***
     * 1.mybatis 允许增删改直接定义以下类型返回值：Integer、Long、Boolean类型
     *      直接在接口上写返回类型，SQL映射文件无法定义相关类型
     * 2.需要手动提交数据
     *      sqlSessionFactory.opensession(); 手动提交数据
     *      sqlSessionFactory.opensession(true); 自动提交数据
     * @throws IOException
     */
//    增删改查操作
    @Test
    public void Test03() throws IOException{
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        //获取改opensession的方法，获取到的sqlSession不会自动提交数据，需要手动提交
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapper  mapper=sqlSession.getMapper(EmployeeMapper.class);
            Employee employee=mapper.getEmpById(1);

//            添加员工操作
            employee=new Employee(null,"jerry","jerry@atguigu.com","1");
            mapper.addEmp(employee);
            System.out.println(employee);

//            //修改操作
//            employee=new Employee(3,"jerry","jerry@atguigu.com","0");
//            boolean flag=mapper.updateEmp(employee);
//            System.out.println(flag);

            //手动提交数据
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }


    //查询使用多参数测试
    @Test
    public void Test04() throws IOException{
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        //获取改opensession的方法，获取到的sqlSession不会自动提交数据，需要手动提交
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapper  mapper=sqlSession.getMapper(EmployeeMapper.class);
            HashMap<String,Object> map=new HashMap<>();
            map.put("id",1);
            map.put("lastName","jerry");
            Employee employee=mapper.getEmpByMap(map);
            System.out.println(employee);

            //手动提交数据
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }
}
