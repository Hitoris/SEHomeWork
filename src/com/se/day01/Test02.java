package com.se.day01;

/**
 * 将"大家好!"修改为:"大家好!我是程序员!"并输出。
 *  * 然后将"大家好!我是程序员!"修改为:"大家好!我是优秀的程序员!"并输出
 *  * 然后再修改为:"大家好!我是牛牛的程序员!"并输出
 *  * 然后在修改为:"我是牛牛的程序员!"并输出
 */
public class Test02 {
    public static void main(String[] args){
        String str = "大家好！";
        StringBuilder s = new StringBuilder(str);
        System.out.println(s.append("我是程序员！"));
        System.out.println(s.replace(6,6,"优秀的"));
        System.out.println(s.replace(6,9,"牛牛的"));
        System.out.println(s.delete(0,4));
    }
}
