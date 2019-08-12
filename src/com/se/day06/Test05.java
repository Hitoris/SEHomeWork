package com.se.day06;

import java.io.File;
import java.util.Scanner;

/**
 * 要求用户输入一个文件或目录名，并删除当前目录下的该文件或目录。
 * 可自行手动先在当前项目目录中创建一个要删除的文件或目录，若是目录，还可以
 * 在该目录中继续创建若干级目录和文件。
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个文件或者目录名称：");
        String name = console.nextLine();
        File file = new File(name);
        if(!file.exists()){
            System.out.println("该文件或目录不存在");
        }else{
            delete(file);
            System.out.println("删除成功");
        }
    }
    // 迭代删除
    public static void delete(File file){
        // 如果是目录，先删除当前目录下的所有子项
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            for(File f : fs){
                delete(f);
            }
        }
        file.delete();
    }
}
