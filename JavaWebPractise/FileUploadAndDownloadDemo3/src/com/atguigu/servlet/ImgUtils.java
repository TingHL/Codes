package com.atguigu.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户上传的图片 保存路径处理工具类
 */
public class ImgUtils {
    //保存了所有的图片路径
    private static List<String> paths=new ArrayList<>();

    public static void addImgPath(String path){
        paths.add(path);
    }

    public static List<String> getAllPaths(){
        return paths;
    }
}
