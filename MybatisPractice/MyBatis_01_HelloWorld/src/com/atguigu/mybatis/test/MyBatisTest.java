package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;

public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource="mybatis-config.xml";
        InputStream inputStream=Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 1.根据xml配置文件（全局配置文件，有数据源一些运行环境信息），例如：mybatis-config.xml文件 创建一个sqlSessionFactory 对象
     * 2.sql 映射文件 配置了每一个sql 以及sql的封装规则等
     * 3.将sql映射文件注册在全局配置文件中
     * 4.
     *  1）根据全局配置文件得到SqlSessionFactory
     *  2）使用sqlSessionFactory 获取sqlSession对象使用其执行增删改查
     *  3）使用sql的唯一标识告诉Mybatis执行哪一个sql。sql都保存在sql映射文件中
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        //项目的主配置文件
        String resource = "mybatis-config.xml";
        //配置文件的流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession实例，能直接执行已经映射的sql语句
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //selectOne 函数
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


    /**
     * 1.接口式编程：
     *  原声：      Dao --> DaoImpl
     *  mybatis：  Mapper --> xxMapper.xml
     *
     *  2. SqlSession 代表和数据库的一次会话，用完必须关闭
     *  3. Sqlsession 和Connection一样都是非线程安全。每次使用都应该去获取新的对象，不能放在共享成员变量中
     *  4. mapper接口没有实现类，但是mybatis会为接口生成一个代理对象
     *      (将接口和XML进行绑定）
     *      EmployeeMapper empMapper=sqlSession.getMapper(EmployeeMapper.class);
     *  5.两个重要的配置文件：
     *      mybatis的全局配置文件，包含数据库连接池信息，事务管理器信息等。。。系统运行环境等
     *      sql映射文件：保存了每一个sql的映射信息，将sql抽取出来
     * @throws IOException
     */
    @Test
    public void Test01() throws IOException {
        //1.获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();

        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
            Employee employee=mapper.getEmpById(1);

            System.out.println(mapper.getClass());  //class com.sun.proxy.$Proxy6
            System.out.println(employee);
        }finally {
            sqlSession.close();
        }

    }
}
