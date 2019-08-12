package com.se.day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 要求用户输入一个文件名，并复制当前目录中该文件，并取名为"原文件名_copy.后缀名"
 * 定义两个方法分别使用单字节形式复制，以及字节数组形式复制
 */
public class Test07 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个文件名：");
        String name = console.nextLine();
        Test07 t = new Test07();
        try {
            t.copy1(name);
            t.copy2(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 使用单字节方式复制
     * @param name 要复制的文件名
     */
    public void copy1(String name) throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(name,"rw");
        String[] names = name.split("\\.");
        RandomAccessFile raf2 = new RandomAccessFile(names[0] + "_copy" + names[1],"rw");
        int b = -1;
        while((b = raf1.read()) != 0){
            raf2.write(b);
        }
        raf1.close();
        raf2.close();
    }
    /**
     * 使用字节数组形式复制
     * @param name 要复制的文件名
     */
    public void copy2(String name) throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(name,"rw");
        String[] names = name.split("\\.");
        RandomAccessFile raf2 = new RandomAccessFile(names[0] + "_copy" + names[1],"rw");
        int len = -1;
        byte[] bs = new byte[1024*1024];
        while ((len = raf1.read(bs)) != 0){
            raf2.write(bs,0,len);
        }
        raf1.close();
        raf2.close();
    }
}
