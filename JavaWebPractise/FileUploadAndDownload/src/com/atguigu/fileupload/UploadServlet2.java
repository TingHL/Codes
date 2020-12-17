package com.atguigu.fileupload;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class UploadServlet2 extends HttpServlet {
    public UploadServlet2() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.判断当前请求是否是一个文件上传请求
        boolean b = FileUpload.isMultipartContent(req);
        if(b){
            //create a factory for disk-based file items
            FileItemFactory factory=new DiskFileItemFactory();
            //create a new file upload hanlder
            ServletFileUpload upload=new ServletFileUpload(factory);

            try {
                //parse the request
                //一个FileItem就是代表一个表单项的详细信息
                List<FileItem> items=upload.parseRequest(req);
                readFileItems(items);
                resp.getWriter().write("OK...");
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }

    //解析每一项表单项的内容
    public void readFileItems(List<FileItem> items) throws IOException {
        int count=0;
        for(FileItem item:items){
            //判断当前是普通表单项还是文件项
            //判断是否普通表单项
            if(item.isFormField()){
                System.out.println("解析到第"+(count++)+"个普通表单项：");
                System.out.println("表单提交的key："+item.getFieldName());
                System.out.println("表单提交的value："+item.getString());
            }else{
                System.out.println("解析到第"+(count++)+"个文件项");
                System.out.println("表单提交的key:"+item.getFieldName());
                System.out.println("上传的文件名："+item.getName());
                System.out.println("文件信息：大小["+item.getSize()+"]字节");
                //获取文件流并保存
                InputStream inputStream=item.getInputStream();

                OutputStream os=new FileOutputStream("F:\\下载\\Test"+item.getName());

                IOUtils.copy(inputStream,os);

                os.close();
                inputStream.close();
            }
        }
    }
}
