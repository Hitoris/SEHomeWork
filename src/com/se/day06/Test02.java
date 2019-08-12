package com.se.day06;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 要求用户输入一个文件名并使用File在当前目录下创建出来。
 * 若该文件已经存在，则提示用户该文件已经存在。并创建该文件副本：
 * 例如:用户输入"test.txt".若该文件已存在，提示用户存在后，创建名为：test_副本1.txt 的文件
 * 若该文件也存在了，则创建名为:test_副本2.txt 的文件，以此类推
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个文件名：");
        String name = console.nextLine();
        File file = new File(name);
        if(file.exists()){
            System.out.println("文件已经存在，为您创建副本");
            int index = 1;
            String first = name.substring(0,name.indexOf("."));
            String last = name.substring(name.indexOf(".") + 1);
            while(true){
                name = first + "_副本" + index + "." + last;
                file = new File(name);
                if(!file.exists()){
                    file.createNewFile();
                    break;
                }
                index ++;
            }
        } else{
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件创建完成");
    }
}
