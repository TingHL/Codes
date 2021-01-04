package com.atguigu.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * �Զ�����ͼ������
 */
public class MyMeiNVViewResolver implements ViewResolver, Ordered {
    Integer order=0;
    /**
     * ������ͼ��������ͼ����
     * @param s
     * @param locale
     * @return
     * @throws Exception
     */
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        //meinv:/gaoqing meinv:/dama forward:/login.jsp
        if(s.startsWith("meinv")){
            return new MyView();
        }else{
            //���ܴ�����null
            return null;
        }
    }

    //ʵ��Orderd��������ͼ�����������ȼ�
    @Override
    public int getOrder() {
        return order;
    }

    //�ı���ͼ�����������ȼ�
    public void setOrder(Integer order){
        this.order=order;
    }
}
