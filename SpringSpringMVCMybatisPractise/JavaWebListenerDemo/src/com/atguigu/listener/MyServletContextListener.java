package com.atguigu.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * 按照以下步骤
 * 1.编写一个监听ServletContext生命周期的Listener；实现Listener接口
 * 2.当前项目web.xml中注册使用
 *
 * ServletContext 置入其中的域属性是整个应用范围的 可以完成跨会话共享数据
 * 在tomcat启动项目的时候 ServletContext就会执行contextInitialized()方法 在关闭tomcat时，ServletContext就会注销掉
 */
public class MyServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        System.out.println("context 初始化"+servletContext);

        // 服务器启动时 进行初始化工作
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("销毁......contextDestroyed");

        //服务器销毁时 进行结束工作
    }
}
