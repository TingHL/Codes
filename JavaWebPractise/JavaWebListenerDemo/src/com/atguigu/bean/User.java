package com.atguigu.bean;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * 实现序列化接口
 * 不需要在web.xml中注册的监听器
 *
 * HttpSessionActivityListener 绑定在session中的对象 活化、钝化监听器
 * HttpSessionBindingListener  对象被绑定在session中的监听器
 */
@WebListener()
public class User implements Serializable, HttpSessionActivationListener,HttpSessionBindingListener{
    //HttpSessionActivationListener 监听实现该接口的类对象的钝化和活化，对应的接口方法包括sessionWillPassivate和sessionDidActivate方法
    /**
     * session将要钝化
     * @param se
     */
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("User "+this+" ...将要和session一起钝化了");
    }

    /**
     * session将要活化
     * @param se
     */
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("User "+this+" ...将要和session一起活化了");
    }


    //HttpSessionBindingListener 监听该对象在session中的操作，修改session中对象实例的属性，注销session中对象实例的属性
    /**
     * 检测这个User对象（这个类对象）绑定到session中
     * @param event
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("User 绑定进来了");
        System.out.println(this+" value:"+event.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("User 解绑了"+event.getValue());
    }
}
