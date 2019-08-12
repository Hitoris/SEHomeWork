package com.se.day07;

import java.io.*;

/**
 * 使用缓冲流复制myfile.txt文件为myfile_cp2.txt
 */
public class Test02 {
    public static void main(String[] args) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("myfile.txt"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("myfile_cp2.txt"));
            int len = -1;
            byte[] bs = new byte[1024*1024];
            while((len = bis.read(bs)) != -1){
                bos.write(bs,0,len);
            }
            bis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
