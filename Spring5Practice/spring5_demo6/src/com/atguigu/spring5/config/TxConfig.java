package com.atguigu.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration //配置类
@ComponentScan(basePackages = "com.atguigu.spring5")  //开启组件扫描
@EnableTransactionManagement //开启事务
public class TxConfig {
//    创建数据库的链接池
    @Bean  //创建对象实例
    public DruidDataSource getDruidDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName("com.alibaba.druid.pool.DruidDataSource");
        dataSource.setUrl("jdbc:mysql://localhost:3306/user_db?useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC");
        dataSource.setName("root2");
        dataSource.setPassword("root");
        return dataSource;
    }

    //jdbcTemplate 模板对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        //到ioc容器中根据类型找到dataSource对象
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //注入DataSource
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    //创建事务管理器的对象
    @Bean
    public DataSourceTransactionManager getDataSourceTrasactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager=new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
