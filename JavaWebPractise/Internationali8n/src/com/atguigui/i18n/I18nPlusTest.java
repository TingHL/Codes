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
     * 支持根据不同区域国际出不同信息:DateFormat、NumberFormat、MessageFormat
     * DateFormat，日期格式化
     *   获取DateFormat实例化
     *      getDateInstance()       获取到的实例类似于 2019-12-13
     *      getDateInstance(int style,Locale aLocale)
     *                              Gets the date formatter with the given formatting style for the given locale.
     *                              style:日期风格。包括FULL（完整）、 LONG（长）、MEDIUM（中等）、SHORT（短）、DEFAULT（默认）
     *      getDateTimeInstance()   获取到的实例类似于 2019-12-13 12:55:12:123
     *      getTimeInstance()       获取到的实例类似于 12:55:12:123
     *
     * NumberFormat，数字格式化
     * MessageFormat，自定义消息格式化
     */
    @Test
    public void test1(){
        Locale canada = Locale.CANADA;
        Locale french = Locale.FRENCH;
        Locale china = Locale.CHINA;
        Locale japan = Locale.JAPAN;
        Locale us = Locale.US;
        Locale italy=Locale.ITALY;

        //1.要按照区域信息格式化日期，先拿到DateFormat实例（日期格式化）
        DateFormat dateInstanceataFormat = DateFormat.getDateInstance(DateFormat.SHORT, japan);
        String format = dateInstanceataFormat.format(new Date());
        System.out.println(format);

        //2.数字格式化
        double salary=123413242.987;
        NumberFormat numberFormat = NumberFormat.getInstance(italy);
        String format1 = numberFormat.format(salary);
        System.out.println(format1);


        //3.货币格式化
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(china);
        String format2 = currencyInstance.format(salary);
        System.out.println(format2);

        //4.消息格式化，自定义消息（文本）格式化
        //示例：张三喜欢李四，但是李四喜欢王五 人名信息动态获取，“喜欢”等词，就会根据国际化进行翻译或者显示
        //国际化中编写规则，{0}表示占位符：likeinfo= {0} like {1}, but {1} like {2}  索引从0开始
        //ResourceBundle 获取国际化配置文件 MessageFormat对获取到的信息传递参数
        //MessageFormat：支持国际化配置文件中写动态占位符
        ResourceBundle bookstore = ResourceBundle.getBundle("bookstore", china);
        String likeinfo = bookstore.getString("likeinfo");
        System.out.println(likeinfo);

        String format3 = MessageFormat.format(likeinfo, "宝宝", "蓉蓉", "哲哲");
        System.out.println(format3);
    }
}
