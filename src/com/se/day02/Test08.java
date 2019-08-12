package com.se.day02;

import java.util.Scanner;

/**
 *
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary;name,age,gender,salary;....
 * 例如:
 * 张三,25,男,5000;李四,26,女,6000;...
 * 然后将每个员工信息解析成Person对象。并存入到一个数组中。
 * 然后循环数组，输出每一个员工信息(输出使用toString返回的字符串)
 */
public class Test08 {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("请输入员工信息：");
        String str = console.nextLine();
        String[] emps = str.split(";");
        for(int i = 0;i < emps.length;i ++){
            String emp = emps[i];
            String[] data = emp.split(",");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = data[2];
            int salary = Integer.parseInt(data[3]);
            Person p = new Person(name,age,gender,salary);
            System.out.println(p.toString());
        }
    }
}
