package com.atguigu.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * �û��ϴ���ͼƬ ����·����������
 */
public class ImgUtils {
    //���������е�ͼƬ·��
    private static List<String> paths=new ArrayList<>();

    public static void addImgPath(String path){
        paths.add(path);
    }

    public static List<String> getAllPaths(){
        return paths;
    }
}
