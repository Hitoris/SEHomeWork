package com.se.day02;

import java.util.Scanner;

/**
 *
 * 输入一个数学计算表达式，如:1+2
 * 然后输出计算后的结果:1+2=3
 * 这里计算表达式只计算一次即可，可以使用加减乘除任意一个,可以进行小数运算。
 */
public class Test07 {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("请输入计算表达式：");
        String str = console.nextLine();
        String[] s = str.split("[\\+\\-\\*\\/]");
        double a = Double.parseDouble(s[0]);
        double b = Double.parseDouble(s[1]);
        String s1 = str.replace(s[0],"");
        String s2 = s1.replace(s[1],"");
        String symbol = s2.trim();
        if(symbol.equals("+")){
            System.out.println(str+"="+(a+b));
        } else if(symbol.equals("-")){
            System.out.println(str+"="+(a-b));
        } else if(symbol.equals("*")){
            System.out.println(str+"="+(a*b));
        } else if(symbol.equals("/")){
            System.out.println(str+"="+(a/b));
        }
    }
}
