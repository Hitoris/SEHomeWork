package com.se.day06;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通过File输出当前项目目录下的文件"myfile.txt"的名字，大小，最后修改时间。
 * 最后修改时间格式如:2017-06-30 14:22:16
 */
public class Test01 {
    public static void main(String[] args) {
        File f = new File("myfile.txt");
        String name = f.getName();
        long length = f.length();
        long time = f.lastModified();
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastModified = sdf.format(date);
        System.out.println("文件名字：" + name);
        System.out.println("文件大小：" + length);
        System.out.println("最后修改时间：" + lastModified);
    }
}
