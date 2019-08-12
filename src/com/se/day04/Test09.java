package com.se.day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 然后循环集合，输出每一个员工信息(输出使用toString返回的字符串)
 * 然后输出每个员工的转正仪式日期。
 * 转正仪式日期为:入职3个月的当周周五
 */
public class Test09 {
    public static void main(String[] args) throws ParseException {
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        String[] emps = str.split(";");
        List<Emp> e = new ArrayList<Emp>();
        System.out.println("请输入员工信息：");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(String s : emps){
            String[] empInfo = s.split(",");
            String name = empInfo[0];
            int age = Integer.parseInt(empInfo[1]);
            String gender = empInfo[2];
            int salary = Integer.parseInt(empInfo[3]);
            Date hiredate = sdf.parse(empInfo[4]);
            Emp emp = new Emp(name,age,gender,salary,hiredate);
            e.add(emp);
        }
        for(Emp es : e){
            System.out.println(es);
            Calendar cal = Calendar.getInstance();
            cal.setTime(es.getHiredate());
            cal.add(Calendar.MONTH,3);
            cal.set(Calendar.DATE,Calendar.FRIDAY);
            Date date = cal.getTime();
            System.out.println(sdf.format(date));
        }
    }
}
