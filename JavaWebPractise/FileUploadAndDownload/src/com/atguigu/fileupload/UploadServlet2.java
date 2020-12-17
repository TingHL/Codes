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
        //1.�жϵ�ǰ�����Ƿ���һ���ļ��ϴ�����
        boolean b = FileUpload.isMultipartContent(req);
        if(b){
            //create a factory for disk-based file items
            FileItemFactory factory=new DiskFileItemFactory();
            //create a new file upload hanlder
            ServletFileUpload upload=new ServletFileUpload(factory);

            try {
                //parse the request
                //һ��FileItem���Ǵ���һ���������ϸ��Ϣ
                List<FileItem> items=upload.parseRequest(req);
                readFileItems(items);
                resp.getWriter().write("OK...");
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }

    //����ÿһ����������
    public void readFileItems(List<FileItem> items) throws IOException {
        int count=0;
        for(FileItem item:items){
            //�жϵ�ǰ����ͨ������ļ���
            //�ж��Ƿ���ͨ����
            if(item.isFormField()){
                System.out.println("��������"+(count++)+"����ͨ���");
                System.out.println("���ύ��key��"+item.getFieldName());
                System.out.println("���ύ��value��"+item.getString());
            }else{
                System.out.println("��������"+(count++)+"���ļ���");
                System.out.println("���ύ��key:"+item.getFieldName());
                System.out.println("�ϴ����ļ�����"+item.getName());
                System.out.println("�ļ���Ϣ����С["+item.getSize()+"]�ֽ�");
                //��ȡ�ļ���������
                InputStream inputStream=item.getInputStream();

                OutputStream os=new FileOutputStream("F:\\����\\Test"+item.getName());

                IOUtils.copy(inputStream,os);

                os.close();
                inputStream.close();
            }
        }
    }
}
