package com.se.day01;

import java.util.Scanner;

/**
 * 检查一个字符串是否为回文
 *  * 回文:正着念与反着念一样，例如:上海自来水来自海上
 */
public class Test03 {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        StringBuilder s = new StringBuilder(str);
        StringBuilder rs = s.reverse();
        String s1 = rs.toString();
        if(str.equals(s1)){
            System.out.println("是回文字符串");
        } else{
            System.out.println("不是回文字符串");
        }
    }
}
