package com.atguigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

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
        //1.导包
        //2.解析
        FileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");

        try{
            List<FileItem> items=upload.parseRequest(req);
            //自定义文件上传
            parseFileItems(items,req);
            //文件上传后，去首页index.jsp展示图片列表
        }catch (FileUploadException e){
            e.printStackTrace();
        }

        //文件上传成功后重定向到首页
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }

    private void parseFileItems(List<FileItem> items,HttpServletRequest request) throws IOException {
        for(FileItem item:items){
            if(item.isFormField()){
                String name=item.getFieldName();
                //解决普通输入项的数据的中文乱码问题
                String value=item.getString("UTF-8");
                System.out.println("formfield域中属性   输入的field："+name+" 值为："+value);
            }else{
                //1.把上传的图片保存在当前项目的pics中
                InputStream is=item.getInputStream();

                //如何获取某个文件或文件夹在服务器中的真正位置  重点细节一
                //一个项目对应一个ServletContext
                ServletContext servletContext=request.getServletContext();
                String realPath = servletContext.getRealPath("/pics");
                //真实路径：F:\Code\Codes\JavaWebPractise\FileUploadAndDownloadDemo2\out\artifacts\FileUploadAndDownloadDemo2_war_exploded\pics
                //获取到的真实路径到pics为止
                System.out.println("/pics的真实路径："+realPath);

                //细节二： IE浏览器下获取到的文件是带路径的 获取最后一个文件名
                //获取文件分隔符分隔的最后一个文件名 使用String类的split()方法会报错
                System.out.println("item.getName():"+item.getName());
                int lastIndexOf=item.getName().lastIndexOf("\\");
                String fileName=item.getName().substring(lastIndexOf+1);
                System.out.println("打印文件名："+fileName);

                //细节三：为了防止同名文件覆盖，可以给文件名+UUID
                fileName = UUID.randomUUID().toString().replace("-","")+fileName;
                //传递到服务器中，在项目中不会显示
                FileOutputStream os = new FileOutputStream(realPath + File.separator + fileName);

                IOUtils.copy(is,os);
                os.close();
                is.close();

                //使用ImgUtils工具类 将上传的文件路径保存在域中 方便获取
                ImgUtils.addImgPath("/pics/"+fileName);
            }

        }
    }
}
