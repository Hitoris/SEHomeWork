package com.se.day02;

import java.util.Scanner;

/**
 * 输入一个IP地址，然后将4段数字分别输出
 */
public class Test03 {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个IP地址：");
        String str = console.nextLine();
        String[] s = str.split("\\.");
        for(int i = 0;i < s.length;i ++){
            System.out.println(s[i]);
        }
    }
}
