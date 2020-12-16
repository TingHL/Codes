package com.atguigu.listener;

import javax.servlet.http.*;


/**
 * HttpSession 置入其中的域属性是整个应用范围的，可以完成跨请求共享数据 会监听session
 *
 */
public class MySessionLifeCycleListener implements HttpSessionListener, HttpSessionAttributeListener {
    //实现HttpSessionListener 接口中的方法
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        System.out.println("session created..."+session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        System.out.println("session destroyed..."+session.getId());
    }



    //实现HttpSessionAttributeListener中的方法  会监听session中的属性的变化
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("session 增加"+name+"属性，值为："+value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("session 删除"+name+"属性，值为："+value);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        String name = event.getName();
        //getValue()方法获取的是旧值
        Object value = event.getValue();
        //通过session获取新值
        HttpSession session = event.getSession();
        Object newValue=session.getAttribute(name);
        System.out.println("session 属性"+name+" 重新绑定，旧值为:"+value+"，新值为:"+newValue);
    }
}
