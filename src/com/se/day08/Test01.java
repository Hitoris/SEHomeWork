package com.se.day08;

import java.io.*;

/**
 * 对myfile.txt文件进行复制操作，要求使用异常捕获
 * 机制对流的异常进行捕获和处理，finally中
 * 要将流关闭
 */
public class Test01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("myfile.txt");
            fos = new FileOutputStream("myfile_cp3.txt");
            int len = -1;
            byte[] bs = new byte[1024*1024];
            while ((len = fis.read(bs)) != -1){
                fos.write(bs,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
