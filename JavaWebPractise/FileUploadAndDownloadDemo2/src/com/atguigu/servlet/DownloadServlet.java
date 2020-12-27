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
            //1.���ļ��������ȷ�Ľ��������
            ServletContext context=req.getServletContext();
            String realPath = context.getRealPath("pics/jar.zip");
            resp.setHeader("Content-Disposition","attachment;filename=item.jpg");
            FileInputStream is=new FileInputStream(realPath);
            ServletOutputStream os=resp.getOutputStream();
            IOUtils.copy(is,os);
            os.close();
            is.close();

            //�������������Ҫ�򿪣������� ����Ӧͷ������������������ؼ���
        }else if(file.equals("jpg")){
            //1.�ҵ�ͼƬ�ڷ������е���ʵλ��  ͨ��ServletContext.getRealPath(����Դ��ַ")
            ServletContext context=req.getServletContext();
            //2.�ҵ�ͼƬ���ڵ���ʵλ��
            String realPath=context.getRealPath("/pics/item.jpg");

            //������Ӧͷ����������������ļ��򿪣�ֱ������ Content-Disposition�����ݵĴ���ʽ
            //filename�������ص�ͼƬ������
            resp.setHeader("Content-Disposition","attachment;filename=item.jpg");

            //3.��ȡҪ���ص��ļ�����
            FileInputStream is = new FileInputStream(realPath);
            //4.д������������
            ServletOutputStream os = resp.getOutputStream();
            //5.������д�������
            IOUtils.copy(is,os);
            os.close();
            is.close();

        }else{
            resp.getWriter().write("Ŀ�겻����");
        }

        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }


    /**
     * errorHandler������ʾ���Ǵ���Ĵ�������ֱ�ӽ������������
     * ������ͻ���Ĭ����Ϊ����ʶ�Ĵ򿪣�����ʶ������
     * ��������jpgͼƬʱ���ͻὫͼƬ���µı�ǩҳ��
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void errorHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = req.getParameter("file");
        if(file.equals("zip")){
            //1.���ļ��������ȷ�Ľ��������
        }else if(file.equals("jpg")){
            //1.�ҵ�ͼƬ�ڷ������е���ʵλ��  ͨ��ServletContext.getRealPath(����Դ��ַ")
            ServletContext context=req.getServletContext();
            //2.�ҵ�ͼƬ���ڵ���ʵλ��
            String realPath=context.getRealPath("/pics/item.jpg");
            System.out.println(realPath);
            //3.��ȡҪ���ص��ļ�����
            FileInputStream is = new FileInputStream(realPath);
            //4.д������������
            ServletOutputStream os = resp.getOutputStream();
            //5.������д�������
            IOUtils.copy(is,os);
            os.close();
            is.close();
        }else{
            resp.getWriter().write("Ŀ�겻����");
        }

        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}
