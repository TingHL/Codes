package com.atguigui.i18n;

import org.junit.Test;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nPlusTest {
    /**
     * ֧�ָ��ݲ�ͬ������ʳ���ͬ��Ϣ:DateFormat��NumberFormat��MessageFormat
     * DateFormat�����ڸ�ʽ��
     *   ��ȡDateFormatʵ����
     *      getDateInstance()       ��ȡ����ʵ�������� 2019-12-13
     *      getDateInstance(int style,Locale aLocale)
     *                              Gets the date formatter with the given formatting style for the given locale.
     *                              style:���ڷ�񡣰���FULL���������� LONG��������MEDIUM���еȣ���SHORT���̣���DEFAULT��Ĭ�ϣ�
     *      getDateTimeInstance()   ��ȡ����ʵ�������� 2019-12-13 12:55:12:123
     *      getTimeInstance()       ��ȡ����ʵ�������� 12:55:12:123
     *
     * NumberFormat�����ָ�ʽ��
     * MessageFormat���Զ�����Ϣ��ʽ��
     */
    @Test
    public void test1(){
        Locale canada = Locale.CANADA;
        Locale french = Locale.FRENCH;
        Locale china = Locale.CHINA;
        Locale japan = Locale.JAPAN;
        Locale us = Locale.US;
        Locale italy=Locale.ITALY;

        //1.Ҫ����������Ϣ��ʽ�����ڣ����õ�DateFormatʵ�������ڸ�ʽ����
        DateFormat dateInstanceataFormat = DateFormat.getDateInstance(DateFormat.SHORT, japan);
        String format = dateInstanceataFormat.format(new Date());
        System.out.println(format);

        //2.���ָ�ʽ��
        double salary=123413242.987;
        NumberFormat numberFormat = NumberFormat.getInstance(italy);
        String format1 = numberFormat.format(salary);
        System.out.println(format1);


        //3.���Ҹ�ʽ��
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(china);
        String format2 = currencyInstance.format(salary);
        System.out.println(format2);

        //4.��Ϣ��ʽ�����Զ�����Ϣ���ı�����ʽ��
        //ʾ��������ϲ�����ģ���������ϲ������ ������Ϣ��̬��ȡ����ϲ�����ȴʣ��ͻ���ݹ��ʻ����з��������ʾ
        //���ʻ��б�д����{0}��ʾռλ����likeinfo= {0} like {1}, but {1} like {2}  ������0��ʼ
        //ResourceBundle ��ȡ���ʻ������ļ� MessageFormat�Ի�ȡ������Ϣ���ݲ���
        //MessageFormat��֧�ֹ��ʻ������ļ���д��̬ռλ��
        ResourceBundle bookstore = ResourceBundle.getBundle("bookstore", china);
        String likeinfo = bookstore.getString("likeinfo");
        System.out.println(likeinfo);

        String format3 = MessageFormat.format(likeinfo, "����", "����", "����");
        System.out.println(format3);
    }
}
