package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class DowloadAfterUploadServlet extends HttpServlet {
    public DowloadAfterUploadServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String file = req.getParameter("file");
        System.out.println("输入的file参数值："+file);
        ServletContext servletContext = getServletContext();
        String realPath=servletContext.getRealPath(file);
        System.out.println("图片所在的真正的位置："+realPath);

        int length= UUID.randomUUID().toString().replace("-","").length();
        //获取文件名
        int lastIndexOf=file.lastIndexOf("/");
        String filename=file.substring(lastIndexOf+1);
        filename = filename.substring(length);

        System.out.println("最终的文件名："+filename);

        //解决中文文件名乱码
        filename=new String(filename.getBytes("GBK"),"ISO-8859-1");


        resp.setHeader("Content-Disposition","attachment;filename="+filename);

        FileInputStream is=new FileInputStream(realPath);
        ServletOutputStream os=resp.getOutputStream();
        IOUtils.copy(is,os);
        os.close();;
        is.close();

        
        //resp.sendRedirect(servletContext.getContextPath()+"/index.jsp");
    }
}
