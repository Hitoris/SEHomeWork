package com.se.day08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * 使用异常捕获机制完成下述读取操作。
 * 使用缓冲流读取note.txt文件，并将每行字符串输出到控制台上
 */
public class Test03 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("note.txt")));
            String str = null;
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }
            br.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
