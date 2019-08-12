package com.se.day06;

import java.io.File;

/**
 * 获取并输出当前目录下的所有文件和目录的名字
 */
public class Test04 {
    public static void main(String[] args) {
        File file = new File(".");
        File[] fs = file.listFiles();
        for(File f : fs){
            if(f.isFile()){
                System.out.println("文件：" + f.getName());
            } else{
                System.out.println("目录：" + f.getName());
            }
        }
    }
}
