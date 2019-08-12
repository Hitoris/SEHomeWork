package com.se.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 实现时间的计算: 要求用户输入身份证号，若格式有误，要求其重新输入。然后根据身份证号码输出20岁生日
 * 所在周的周三的日期。
 * 例如:
 * 出生日期:1992-07-15。
 * 20岁生日:2012-07-15
 * 当周的周三为:2012-07-18
 */
public class Test05 {
    public static void main(String[] args) throws ParseException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入身份证号：");
        String str = console.nextLine();
        String regex = "[1-9]\\d{5}[1|2][0-9]{11}";
        if(str.matches(regex)){
            String birYear = str.substring(6,10);
            String birMoth = str.substring(10,12);
            String birDay = str.substring(12,14);
            StringBuilder sb = new StringBuilder(birYear);
            sb.append("-");
            sb.append(birMoth);
            sb.append("-");
            sb.append(birDay);
            String bir = sb.toString();
            System.out.println("出生日期为："+bir);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(bir);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.YEAR,20);
            date = cal.getTime();
            bir = sdf.format(date);
            System.out.println("20岁生日为："+bir);
            cal.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
            date = cal.getTime();
            bir = sdf.format(date);
            System.out.println(bir);
        } else{
            System.out.println("请重新输入：");
            str = console.nextLine();
        }
    }
}
