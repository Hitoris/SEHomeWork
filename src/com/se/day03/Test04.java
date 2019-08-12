package com.se.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 2018-03-25
 * 输入一个生产日期格式"yyyy-MM-dd",再输入一个数字(保质期的天数)。
 * 然后经过计算输出促销日期，促销日期为:该商品过期日前2周的周三
 */
public class Test04 {
    public static void main(String[] args) throws ParseException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入一个生产日期：");
        String produceDate = console.nextLine();
        System.out.println("请输入保质期的天数：");
        int day = console.nextInt();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.parse(produceDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,day);
        cal.add(Calendar.DATE,-14);
        cal.set(Calendar.DATE, Calendar.WEDNESDAY);
        date = cal.getTime();
        String s = sdf.format(date);
        System.out.println(s);
    }
}
