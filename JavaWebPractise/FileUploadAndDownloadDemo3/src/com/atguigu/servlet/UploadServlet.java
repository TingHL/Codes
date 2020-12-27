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
        //1.����
        //2.����
        FileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");

        try{
            List<FileItem> items=upload.parseRequest(req);
            //�Զ����ļ��ϴ�
            parseFileItems(items,req);
            //�ļ��ϴ���ȥ��ҳindex.jspչʾͼƬ�б�
        }catch (FileUploadException e){
            e.printStackTrace();
        }

        //�ļ��ϴ��ɹ����ض�����ҳ
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }

    private void parseFileItems(List<FileItem> items,HttpServletRequest request) throws IOException {
        for(FileItem item:items){
            if(item.isFormField()){
                String name=item.getFieldName();
                //�����ͨ����������ݵ�������������
                String value=item.getString("UTF-8");
                System.out.println("formfield��������   �����field��"+name+" ֵΪ��"+value);
            }else{
                //1.���ϴ���ͼƬ�����ڵ�ǰ��Ŀ��pics��
                InputStream is=item.getInputStream();

                //��λ�ȡĳ���ļ����ļ����ڷ������е�����λ��  �ص�ϸ��һ
                //һ����Ŀ��Ӧһ��ServletContext
                ServletContext servletContext=request.getServletContext();
                String realPath = servletContext.getRealPath("/pics");
                //��ʵ·����F:\Code\Codes\JavaWebPractise\FileUploadAndDownloadDemo2\out\artifacts\FileUploadAndDownloadDemo2_war_exploded\pics
                //��ȡ������ʵ·����picsΪֹ
                System.out.println("/pics����ʵ·����"+realPath);

                //ϸ�ڶ��� IE������»�ȡ�����ļ��Ǵ�·���� ��ȡ���һ���ļ���
                //��ȡ�ļ��ָ����ָ������һ���ļ��� ʹ��String���split()�����ᱨ��
                System.out.println("item.getName():"+item.getName());
                int lastIndexOf=item.getName().lastIndexOf("\\");
                String fileName=item.getName().substring(lastIndexOf+1);
                System.out.println("��ӡ�ļ�����"+fileName);

                //ϸ������Ϊ�˷�ֹͬ���ļ����ǣ����Ը��ļ���+UUID
                fileName = UUID.randomUUID().toString().replace("-","")+fileName;
                //���ݵ��������У�����Ŀ�в�����ʾ
                FileOutputStream os = new FileOutputStream(realPath + File.separator + fileName);

                IOUtils.copy(is,os);
                os.close();
                is.close();

                //ʹ��ImgUtils������ ���ϴ����ļ�·������������ �����ȡ
                ImgUtils.addImgPath("/pics/"+fileName);
            }

        }
    }
}
