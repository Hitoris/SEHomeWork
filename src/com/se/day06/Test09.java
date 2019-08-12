package com.se.day06;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 创建一个文件"note.txt",然后通过控制台输入的每一行字符串都按行写入到
 * note.txt中。当输入的字符串为"exit"时退出程序。
 */
public class Test09 {
    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter("note.txt");
            Scanner console = new Scanner(System.in);
            System.out.println("请输入要写入的内容：");
            while (true){
                String str = console.nextLine();
                if(!str.equals("exit")){
                    pw.println(str);
                } else {
                    break;
                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
