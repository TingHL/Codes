package com.atguigu.spring5.testdemo.service;

import com.atguigu.spring5.testdemo.dao.UserDao;
import com.atguigu.spring5.testdemo.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//在注解里面value属性值可以省略不写  默认值是类名称，首字母小写  创建id为userService的单实例
@Component(value="userService")  //<bean id="userService" class=""/> 等价
public class UserService {
////    定义dao类型属性 不需要set方法 添加注入属性注解
//    @Autowired
//    @Qualifier(value = "userDaoImpl")
//    private UserDao userDao;

//    @Resource  //根据类型进行注入
    @Resource(name = "userDaoImpl") //依据名称进行注入
    private UserDao userDao;

    @Value(value = "abc") //@注入属性值
    private String nname;
    public void add(){
        System.out.println("service add ......"+nname);
        userDao.add();
    }
}
