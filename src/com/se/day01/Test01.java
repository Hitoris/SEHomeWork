package com.se.day01;

/**
 *
 *  * 1:输出字符串"HelloWorld"的字符串长度
 *  * 2:输出"HelloWorld"中"o"的位置
 *  * 3:输出"HelloWorld"中从下标5出开始第一次出现"o"的位置
 *  * 4:截取"HelloWorld"中的"Hello"并输出
 *  * 5:截取"HelloWorld"中的"World"并输出
 *  * 6:将字符串"  Hello   "中两边的空白去除后输出
 *  * 7:输出"HelloWorld"中第6个字符"W"
 *  * 8:输出"HelloWorld"是否是以"h"开头和"ld"结尾的。
 *  * 9:将"HelloWorld"分别转换为全大写和全小写并输出。
 */
public class Test01 {

    public static void main(String[] args) {
        String str = "HelloWorld";
        test1(str);
        test2(str);
        test3(str);
        test4(str);
        test5(str);
        test6(str);
        test7(str);
        test8(str);
        test9(str);
    }
    private static void test1(String str) {
        System.out.println(str.length());
    }
    private static void test2(String str) {
        System.out.println(str.indexOf("o"));
    }
    private static void test3(String str) {
        System.out.println(str.indexOf("o",5));
    }
    private static void test4(String str) {
        System.out.println(str.substring(0,5));
    }
    private static void test5(String str) {
        System.out.println(str.substring(5,str.length()));
    }
    private static void test6(String str) {
        System.out.println(str.trim());
    }
    private static void test7(String str) {
        System.out.println(str.indexOf(6));
    }
    private static void test8(String str) {
        System.out.println(str.startsWith("h"));
        System.out.println(str.endsWith("ld"));
    }
    private static void test9(String str) {
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
    }
}
