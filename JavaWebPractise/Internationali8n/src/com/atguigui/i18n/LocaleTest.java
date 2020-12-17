package com.atguigui.i18n;


import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Locale代表区域信息
 * 每一个区域可以使用一个Locale对象来进行表示
 */
public class LocaleTest {
    @Test
    public void Test01(){
        //获取所有的区域信息
        //zh_CN: 语言代码_国家代码
        Locale[] availableLocales = Locale.getAvailableLocales();
//        for (Locale locale:availableLocales) {
//            System.out.println(locale);
//        }

        //1.判断当前系统所处的系统环境信息
        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault);
    }


    /**
     * bookstore_zh_CN.properties  命名规则:自定义名称_语言代码_国家代码.properties
     * properties文件用于保存一些属性
     *
     * Locale：取悦信息
     * ResourceBundle：资源绑定，管理资源
     *
     * 1.将要按照区域信息不同要动态显示的信息放在配置文件（国际化配置文件）中
     *      要求：起名: 基础名_语言代码_国家代码.properties
     * 2.ResourceBundler绑定所有的国际化资源文件（管理所有的国际化资源文件）
     */
    @Test
    public void test02(){
        Locale china = Locale.CHINA;
        Locale us=Locale.US;

        //1.根据区域信息管理国际化资源文件
        ResourceBundle bundle = ResourceBundle.getBundle("bookstore",china);
        //2.根据当前区域动态的获取到国际化配置文件中某个key的值
        String string=bundle.getString("username");
        System.out.println(string);
    }
}
