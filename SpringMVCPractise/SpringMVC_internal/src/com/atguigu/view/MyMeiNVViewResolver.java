package com.atguigu.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * 自定以视图解析器
 */
public class MyMeiNVViewResolver implements ViewResolver, Ordered {
    Integer order=0;
    /**
     * 根据视图名返回视图对象
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
            //不能处理返回null
            return null;
        }
    }

    //实现Orderd方法，视图解析器的优先级
    @Override
    public int getOrder() {
        return order;
    }

    //改变视图解析器的优先级
    public void setOrder(Integer order){
        this.order=order;
    }
}
