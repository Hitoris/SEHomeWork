package com.se.day07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户控制台输入想输入的员工人数（至少5个），然后依序输入员工信息，每行为
 * 一条员工信息，格式如:张三,25,男,5000,2006-3-18
 * 然后将该对象写入到文件<name>.obj并保存到当前项目根目录中，例如:张三.obj。
 */
public class Test03 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入想输入的员工人数（至少5个）：");
        int num = Integer.parseInt(console.nextLine());
        for(int i = 1;i <= num;i ++){
            System.out.println("请输入第" + i + "名员工的信息：");
            String str = console.nextLine();
            String[] s = str.split(",");
            String name = s[0];
            int age = Integer.parseInt(s[1]);
            String gender = s[2];
            int salary = Integer.parseInt(s[3]);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date hiredate = sdf.parse(s[4]);
            Emp emp = new Emp(name,age,gender,salary,hiredate);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(emp.getName()+".obj")));
            pw.println(emp);
            pw.close();
        }
    }
}
