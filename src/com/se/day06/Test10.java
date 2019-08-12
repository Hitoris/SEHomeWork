package com.se.day06;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入一个员工信息，格式为：
 * name,age,gender,salary,hiredate
 * 例如:
 * 张三,25,男,5000,2006-02-15
 * 然后将输入的员工信息解析成Emp对象。
 * 然后将该Emp对象的toString返回的字符串写入到文件中，该文件的
 * 名字为:name.emp,以上面的例子，那么该文件名为:张三.emp
 * 至少运行5次该程序，输入五个员工信息，并生成5个文件。
 */
public class Test10 {
    public static void main(String[] args) throws ParseException, IOException {
        Scanner console = new Scanner(System.in);
        while (true){
            System.out.println("请输入一个员工信息：");
            String str = console.nextLine();
            String[] s = str.split(",");
            String name = s[0];
            int age = Integer.parseInt(s[1]);
            String gender = s[2];
            int salary = Integer.parseInt(s[3]);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date hiredate = sdf.parse(s[4]);
            Emp emp = new Emp(name,age,gender,salary,hiredate);
            RandomAccessFile raf = new RandomAccessFile(emp.getName() + ".emp","rw");
            raf.write(emp.toString().getBytes());
            raf.close();
            System.out.println("成功生成一个emp文件");
        }
    }
}
