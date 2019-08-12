package com.se.day07;

import java.io.*;
import java.util.Scanner;

/**
 * 要求用户输入一个文件，该文件应当是Test07程序生成的文件，然后将该文件中所有字符读取
 * 出来，并以UTF-8编码写入到另一个文件中，实现文件转码工作，该文件取名格式:原文件名_utf.txt。
 */
public class Test07 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个文件名：");
        String fileName = console.nextLine();
        String first = fileName.substring(0,fileName.indexOf("."));
        String last = fileName.substring(fileName.indexOf(".")+1);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(first+"_utf."+last),"UTF-8"));
            String s = null;
            while ((s = br.readLine()) != null){
                pw.println(s);
            }
            br.close();
            pw.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
