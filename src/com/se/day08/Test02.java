package com.se.day08;

import java.io.*;
import java.util.Scanner;

/**
 * 使用异常捕获完成下述操作
 * 将控制台输入的每一行字符串使用缓冲字符输出流PrintWriter
 * 按行以GBK编码写入到文件note.txt中
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一行字符串：");
        while (true){
            String str = console.nextLine();
            try {
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("note.txt",true),"GBK"));
                pw.println(str);
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
    }
}
