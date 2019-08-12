package com.se.day06;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 要求用户输入一个目录名并使用File在当前目录下创建出来。
 * 若该目录已经存在，则提示用户该目录已经存在。并创建副本，原则与第二题一致。
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("情输入一个目录名：");
        String dirName = console.nextLine();
        File file = new File(dirName);
        if(file.exists()){
            System.out.println("该目录名已经存在，为您创建副本");
            int index = 1;
            while(true){
                String name = dirName + "_副本" + index;
                file = new File(name);
                if(!file.exists()){
                    file.mkdir();
                    break;
                }
                index ++;
            }
        } else {
            file.mkdir();
        }
        System.out.println("目录创建完成");
    }
}
