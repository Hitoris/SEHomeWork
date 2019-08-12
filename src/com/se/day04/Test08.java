package com.se.day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 通过控制台输入3个日期(yyyy-MM-dd格式)，然后转换为Date对象后存入
 * 集合，然后对该集合排序后输出所有日期。
 */
public class Test08 {
    public static void main(String[] arg){
        Scanner console = new Scanner(System.in);
        List<Date> list = new ArrayList<Date>();
        for(int i = 1;i <= 3;i ++){
            System.out.println("请输入第" + i + "个日期：");
            String str = console.nextLine();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = sdf.parse(str);
                list.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
