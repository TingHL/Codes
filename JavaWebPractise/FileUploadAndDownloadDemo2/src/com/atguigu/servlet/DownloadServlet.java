package com.atguigu.servlet;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownloadServlet extends HttpServlet {
    public DownloadServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = req.getParameter("file");
        if(file.equals("zip")){
            //1.将文件流如何正确的交给浏览器
            ServletContext context=req.getServletContext();
            String realPath = context.getRealPath("pics/jar.zip");
            resp.setHeader("Content-Disposition","attachment;filename=item.jpg");
            FileInputStream is=new FileInputStream(realPath);
            ServletOutputStream os=resp.getOutputStream();
            IOUtils.copy(is,os);
            os.close();
            is.close();

            //命令浏览器，不要打开，请下载 在响应头中设置浏览器进行下载即可
        }else if(file.equals("jpg")){
            //1.找到图片在服务器中的真实位置  通过ServletContext.getRealPath(“资源地址")
            ServletContext context=req.getServletContext();
            //2.找到图片所在的真实位置
            String realPath=context.getRealPath("/pics/item.jpg");

            //设置响应头，设置浏览器不将文件打开，直接下载 Content-Disposition：内容的处理方式
            //filename设置下载的图片的名字
            resp.setHeader("Content-Disposition","attachment;filename=item.jpg");

            //3.获取要下载的文件的流
            FileInputStream is = new FileInputStream(realPath);
            //4.写给浏览器输出流
            ServletOutputStream os = resp.getOutputStream();
            //5.输入流写给输出流
            IOUtils.copy(is,os);
            os.close();
            is.close();

        }else{
            resp.getWriter().write("目标不存在");
        }

        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }


    /**
     * errorHandler方法演示的是错误的处理方法，直接将流交给浏览器
     * 浏览器就会有默认行为，认识的打开，不认识的下载
     * 例如下载jpg图片时，就会将图片在新的标签页打开
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void errorHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = req.getParameter("file");
        if(file.equals("zip")){
            //1.将文件流如何正确的交给浏览器
        }else if(file.equals("jpg")){
            //1.找到图片在服务器中的真实位置  通过ServletContext.getRealPath(“资源地址")
            ServletContext context=req.getServletContext();
            //2.找到图片所在的真实位置
            String realPath=context.getRealPath("/pics/item.jpg");
            System.out.println(realPath);
            //3.获取要下载的文件的流
            FileInputStream is = new FileInputStream(realPath);
            //4.写给浏览器输出流
            ServletOutputStream os = resp.getOutputStream();
            //5.输入流写给输出流
            IOUtils.copy(is,os);
            os.close();
            is.close();
        }else{
            resp.getWriter().write("目标不存在");
        }

        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}
