package com.atguigu.bean;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * ʵ�����л��ӿ�
 * ����Ҫ��web.xml��ע��ļ�����
 *
 * HttpSessionActivityListener ����session�еĶ��� ����ۻ�������
 * HttpSessionBindingListener  ���󱻰���session�еļ�����
 */
@WebListener()
public class User implements Serializable, HttpSessionActivationListener,HttpSessionBindingListener{
    //HttpSessionActivationListener ����ʵ�ָýӿڵ������Ķۻ��ͻ����Ӧ�Ľӿڷ�������sessionWillPassivate��sessionDidActivate����
    /**
     * session��Ҫ�ۻ�
     * @param se
     */
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("User "+this+" ...��Ҫ��sessionһ��ۻ���");
    }

    /**
     * session��Ҫ�
     * @param se
     */
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("User "+this+" ...��Ҫ��sessionһ����");
    }


    //HttpSessionBindingListener �����ö�����session�еĲ������޸�session�ж���ʵ�������ԣ�ע��session�ж���ʵ��������
    /**
     * ������User�����������󣩰󶨵�session��
     * @param event
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("User �󶨽�����");
        System.out.println(this+" value:"+event.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("User �����"+event.getValue());
    }
}
