package com.se.day08;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 使用异常捕获机制完成下述读取操作
 * 读取emp.txt文件，并将每个员工信息读取出来，以一个Emp实例保存，然后将
 * 这些Emp实例存入到一个Map集合中。其中key为字符串，是该员工名字，而value
 * 是该Emp实例。
 * 存入后，要求用户输入一个员工的名字,如:张三
 * 若该员工存在则输出该员工所有信息(Emp的toString方法返回的字符串)
 * 输入的员工名若是英文，不要求区分大小写。
 * 若输入的员工名字不存在，则显示"查无此人"
 */
public class Test04 {
    public static Emp emp;
    public static void main(String[] args) {
        try {
            Map<String ,Emp> map = new HashMap<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("emp.txt")));
            String s = null;
            while ((s = br.readLine()) != null){
                String[] ss = s.split(",");
                String name = ss[0];
                int age = Integer.parseInt(ss[1]);
                String gender = ss[2];
                int salary = Integer.parseInt(ss[3]);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date hiredate = sdf.parse(ss[4]);
                emp = new Emp(name,age,gender,salary,hiredate);
                map.put(emp.getName().toLowerCase(),emp);
            }
            Scanner console = new Scanner(System.in);
            System.out.println("请输入一个员工姓名：");
            String name = console.nextLine();
            if(map.containsKey(name)){
                System.out.println(map.get(name).toString());
            } else {
                System.out.println("查无此人");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
