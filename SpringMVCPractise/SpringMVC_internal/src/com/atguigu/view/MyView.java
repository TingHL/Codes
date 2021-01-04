package com.atguigu.view;

import org.springframework.web.servlet.View;

import java.util.Map;

//自定义实现视图 自己进行渲染
public class MyView implements View {
    //
    @Override
    public void render(Map<String, ?> map, javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("之前保存的数据："+map);
        httpServletResponse.getWriter().write("哈哈<h1>即将展示精彩内容</h1>");
    }

    //返回的数据类型
    @Override
    public String getContentType() {
        return "text/html";
    }
}
