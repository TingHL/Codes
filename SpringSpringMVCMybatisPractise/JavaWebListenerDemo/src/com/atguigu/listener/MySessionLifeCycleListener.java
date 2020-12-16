package com.atguigu.listener;

import javax.servlet.http.*;


/**
 * HttpSession �������е�������������Ӧ�÷�Χ�ģ�������ɿ����������� �����session
 *
 */
public class MySessionLifeCycleListener implements HttpSessionListener, HttpSessionAttributeListener {
    //ʵ��HttpSessionListener �ӿ��еķ���
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



    //ʵ��HttpSessionAttributeListener�еķ���  �����session�е����Եı仯
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("session ����"+name+"���ԣ�ֵΪ��"+value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("session ɾ��"+name+"���ԣ�ֵΪ��"+value);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        String name = event.getName();
        //getValue()������ȡ���Ǿ�ֵ
        Object value = event.getValue();
        //ͨ��session��ȡ��ֵ
        HttpSession session = event.getSession();
        Object newValue=session.getAttribute(name);
        System.out.println("session ����"+name+" ���°󶨣���ֵΪ:"+value+"����ֵΪ:"+newValue);
    }
}
