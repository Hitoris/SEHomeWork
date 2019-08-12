package com.se.day06;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取并输出当前目录下所有文件的名字
 */
public class Test06 {
    public static void main(String[] args) {
        File files = new File(".");
        File[] fs = files.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile();
            }
        });
        for(File f : fs){
            System.out.println(f.getName());
        }
    }
}
