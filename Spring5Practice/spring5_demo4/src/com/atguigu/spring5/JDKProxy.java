package com.atguigu.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {

    public static void main(String[] args) {
        //创建接口实现类的代理对象
        Class[] interfaces={UserDao.class};
        UserDaoImpl userDaoImpl=new UserDaoImpl();
        //接口等于实现类的代理对象
        UserDao dao =(UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),interfaces,new UserDaoProxy(userDaoImpl));
        int result=dao.add(1,2);
        System.out.println(result);
        dao.update("1234556Strings");
    }

}

//创建代理对象代码 里面写增强逻辑
class UserDaoProxy implements InvocationHandler {
    //1. 把被代理对象传递进来
    public Object obj;

    //通过有参构造进行传递
    public UserDaoProxy(Object obj){
        this.obj=obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //增强方法之前
        //method.getName() 获得执行方法的名字
        System.out.println("方法之前执行："+method.getName()+"传递的参数:"+ Arrays.toString(args));

        if(method.getName()=="add"){
            //执行类原有方法
            Object res=method.invoke(obj,args);
            //增强方法之后
            System.out.println("方法之后执行："+obj);
            return res;
        }else{
            //执行类原有方法
            Object res=method.invoke(obj,args);
            //方法执行
            System.out.println("方法执行之后："+obj);
            return null;
        }
    }
}
