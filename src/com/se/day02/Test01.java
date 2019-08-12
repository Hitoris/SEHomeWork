package com.se.day02;

import org.junit.Test;

import java.util.Scanner;

/**
 * 要求用户输入一个字符串，然后若该字符串是一个整数，则转换为整数后输出乘以10后的结果
 *  * 若是小数，则转换为一个小数后输出乘以5后的结果，若不是数字则输出"不是数字"
 *  * 需要使用正则表达式进行判断。
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        String zhengshu = "(\\+|\\-)?\\d+";
        String xiaoshu = "(\\-)?\\d+(\\.\\d+)?";
        if(str.matches(zhengshu)){
            int n = Integer.parseInt(str) * 10;
            System.out.println(n);
        } else if(str.matches(xiaoshu)){
             double m = Double.parseDouble(str) * 5;
            System.out.println(m);
        }else{
            System.out.println("不是数字");
        }
    }

}
