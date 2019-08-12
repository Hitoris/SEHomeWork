package com.se.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流复制myfile.txt文件为myfile_cp.txt
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("myfile.txt");
            FileOutputStream fos = new FileOutputStream("myfile_cp.txt");
            int b = -1;
            byte[] bs = new byte[1024*1024];
            while((b = fis.read(bs)) != -1){
                fos.write(bs,0,b);
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
