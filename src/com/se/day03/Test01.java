package com.se.day03;

import java.util.Date;

/**
 * 使用Date输出当前系统时间，以及3天后这一刻的时间
 */
public class Test01 {
    public static void main(String[] args){
        Date date = new Date();
        System.out.println(date);
        date.setTime(date.getTime() + 24*60*60*1000*3);
        System.out.println(date);
    }
}
