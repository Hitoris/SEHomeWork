package com.se.day05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个List集合中。
 * 并对集合排序，然后输出每个员工信息。
 *
 * 再根据员工的入职时间排序，入职晚的在前，早的在后并
 * 输出每个员工的信息。
 */
public class Test03 {
    public static void main(String[] args) throws ParseException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入员工信息：");
        String str = console.nextLine();
        String[] s = str.split(";");
        List<Emp> list = new ArrayList<Emp>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(String ss : s){
            String[] emps = ss.split(",");
            String name = emps[0];
            int age = Integer.parseInt(emps[1]);
            String gender = emps[2];
            int salary = Integer.parseInt(emps[3]);
            Date hiredate = sdf.parse(emps[4]);
            Emp emp = new Emp(name,age,gender,salary,hiredate);
            if(list.contains(emp)){
                System.out.println("该员工已经存在，请重新输入：");
            }else{
                list.add(emp);
            }
        }
        for(Emp e : list){
            System.out.println(e);
        }
        Comparator<Emp> c = new Comparator<Emp>() {
            @Override
            public int compare(Emp e1, Emp e2) {
                long time = e2.getHiredate().getTime() - e1.getHiredate().getTime();
                return time > 0 ? 1:-1;
            }
        };
        Collections.sort(list,c);
        System.out.println("按照入职时间顺序排序为：");
        for(Emp e : list){
            System.out.println(e);
        }
    }
}
