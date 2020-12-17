package com.atguigu.fileupload;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UploadServlet extends HttpServlet {
    public UploadServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //文件是以流的方式交给服务器
//        String username = req.getParameter("username");
//        System.out.println("username"+username);
//        resp.getWriter().write(username);

        //common-io-2.0.jar简化所有流操作
        ServletInputStream inputStream = req.getInputStream();
        String s = IOUtils.toString(inputStream);
        System.out.println(s);
        resp.getWriter().write("ok...");
    }
}
