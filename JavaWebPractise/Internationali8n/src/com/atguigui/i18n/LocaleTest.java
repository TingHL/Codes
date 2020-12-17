package com.atguigui.i18n;


import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Locale����������Ϣ
 * ÿһ���������ʹ��һ��Locale���������б�ʾ
 */
public class LocaleTest {
    @Test
    public void Test01(){
        //��ȡ���е�������Ϣ
        //zh_CN: ���Դ���_���Ҵ���
        Locale[] availableLocales = Locale.getAvailableLocales();
//        for (Locale locale:availableLocales) {
//            System.out.println(locale);
//        }

        //1.�жϵ�ǰϵͳ������ϵͳ������Ϣ
        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault);
    }


    /**
     * bookstore_zh_CN.properties  ��������:�Զ�������_���Դ���_���Ҵ���.properties
     * properties�ļ����ڱ���һЩ����
     *
     * Locale��ȡ����Ϣ
     * ResourceBundle����Դ�󶨣�������Դ
     *
     * 1.��Ҫ����������Ϣ��ͬҪ��̬��ʾ����Ϣ���������ļ������ʻ������ļ�����
     *      Ҫ������: ������_���Դ���_���Ҵ���.properties
     * 2.ResourceBundler�����еĹ��ʻ���Դ�ļ����������еĹ��ʻ���Դ�ļ���
     */
    @Test
    public void test02(){
        Locale china = Locale.CHINA;
        Locale us=Locale.US;

        //1.����������Ϣ������ʻ���Դ�ļ�
        ResourceBundle bundle = ResourceBundle.getBundle("bookstore",china);
        //2.���ݵ�ǰ����̬�Ļ�ȡ�����ʻ������ļ���ĳ��key��ֵ
        String string=bundle.getString("username");
        System.out.println(string);
    }
}
