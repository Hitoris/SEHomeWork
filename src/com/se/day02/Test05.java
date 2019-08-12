package com.se.day02;

import java.util.Scanner;

/**
 *    实现文件重命名。
 *  * 要求用户输入一个文件名称，例如:abc.jpg
 *  * 然后对该名字进行重新命名，输出的格式为:系统时间毫秒值.jpg
 *  * 例如:1465266796279.jpg
 */
public class Test05 {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个文件名称：");
        String str = console.nextLine();
        String[] s = str.split("\\.");
        StringBuilder sb = new StringBuilder(String.valueOf(System.currentTimeMillis()));
        sb.append(".jpg");
        System.out.println(sb.toString());
    }
}
