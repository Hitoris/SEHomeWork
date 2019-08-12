package com.se.day07;

import java.io.*;
import java.util.Scanner;

/**
 * 记事本功能，首先要求用户输入一个文件名，并将该文件创建出来，
 * 然后通过控制台输入的每一行字符串都按行写入到该文件中，并
 * 使用GBK编码保存。当输入的字符串为"exit"时退出程序。
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个文件名：");
        String fileName = console.nextLine();
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName),"GBK"));
            while (true){
                System.out.println("请输入需要写入的字符串，退出请输入exit：");
                String str = console.nextLine();
                if(!str.equals("exit")){
                    pw.println(str);
                } else {
                    System.out.println("退出成功");
                    break;
                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
