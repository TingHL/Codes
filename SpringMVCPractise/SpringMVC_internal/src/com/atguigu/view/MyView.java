package com.atguigu.view;

import org.springframework.web.servlet.View;

import java.util.Map;

//�Զ���ʵ����ͼ �Լ�������Ⱦ
public class MyView implements View {
    //
    @Override
    public void render(Map<String, ?> map, javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("֮ǰ��������ݣ�"+map);
        httpServletResponse.getWriter().write("����<h1>����չʾ��������</h1>");
    }

    //���ص���������
    @Override
    public String getContentType() {
        return "text/html";
    }
}
