package com.se.day07;

import java.io.*;

/**
 * 使用字符流复制当前程序的源文件到当前项目根目录下。
 */
public class Test05 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src"+ File.separator+"com"+File.separator+"se"+File.separator+"day07"+File.separator+"Test05.java");
            InputStreamReader isr = new InputStreamReader(fis);
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("."));
            int b = -1;
            while ((b = isr.read()) != -1){
                osw.write(b);
            }
            System.out.println("复制完毕");
            isr.close();
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
