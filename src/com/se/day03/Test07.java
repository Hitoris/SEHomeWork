package com.se.day03;

import com.se.day02.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 要求用户首先输入员工数量，然后输入相应员工信息，格式为：
 * name,age,gender,salary,hiredate
 * 例如:
 * 张三,25,男,5000,2006-02-15
 * 每一行为一个员工信息，然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 在解析成Emp对象后要先查看当前集合是否包含该员工，若包含则提示该用于已存在，
 * 否则才存入集合。
 * 然后输出集合查看每个员工信息.
 */
public class Test07 {
    public static void main(String[] args) throws ParseException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入要解析的员工数量：");
        int num = Integer.parseInt(console.nextLine());
        List<Emp> emps = new ArrayList<Emp>();
        for(int i = 1;i <= num;){
            System.out.println("请输入第"+i+"个员工信息：");
            String str = console.nextLine();
            String[] empInfo = str.split(",");
            String name = empInfo[0];
            int age = Integer.parseInt(empInfo[1]);
            String gender = empInfo[2];
            int salary = Integer.parseInt(empInfo[3]);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date hiredate = sdf.parse(empInfo[4]);
            Emp emp = new Emp(name,age,gender,salary,hiredate);
            if(emps.contains(emp)){
                System.out.println("该员工已经存在");
                continue;
            }
            emps.add(emp);
            i++;
        }
        System.out.println(emps);
    }
}
