package com.se.day06;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 编写一个程序，将当前目录下所有的员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入Map。其中key为该员工的名字，value为该员工的emp对象。
 * 然后，要求用户输入一个员工名字，若该员工存在，则输出该员工的名字，年龄，工资，以及入职20周年的纪念日当周的周六的日期。
 * 即:输入名字"张三"
 * 若该员工存在，则输出如下格式:
 * 张三,25,5000,2006-02-14
 * 入职20周年纪念日派对日期: 2026-02-14  （注:若入职日期为:2006-02-14）
 * 若该员工不存在，则输出:"查无此人"
 */
public class Test12 {
    public static Emp emp;
    public static void main(String[] args) {
        File dir = new File(".");
        Test12 t = new Test12();
        List<Emp> list = t.loadEmp(dir);
        Map<String,Emp> map = new HashMap<>();
        for(Emp e : list){
            map.put(e.getName(),e);
        }
        Scanner console = new Scanner(System.in);
        while (true){
            System.out.println("请输入一个员工姓名：");
            String name = console.nextLine();
            if(map.containsKey(name)){
                System.out.println(map.get(name).toString());
                Calendar cal = Calendar.getInstance();
                cal.setTime(map.get(name).getHiredate());
                cal.add(Calendar.YEAR,20);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("入职20周年纪念日派对日期为:" + sdf.format(cal.getTime()));
            } else {
                System.out.println("查无此人");
            }
        }
    }
    // 读取Emp文件，将其存入List
    public List<Emp> loadEmp(File dir){
        List<Emp> list = new ArrayList<>();
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith("emp");
            }
        });
        for(File f : files){
            list.add(empInfo(f));
        }
        return list;
    }
    // 解析Emp对象
    public Emp empInfo(File file){
        try {
            RandomAccessFile raf = new RandomAccessFile(file,"r");
            byte[] bs = new byte[1024*1024];
            int len = raf.read(bs);
            String str = new String(bs,0,len);
            String[] s = str.split(",");
            String name = s[0];
            int age = Integer.parseInt(s[1]);
            String gender = s[2];
            int salary = Integer.parseInt(s[3]);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date hiredate = sdf.parse(s[4]);
            emp = new Emp(name,age,gender,salary,hiredate);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return emp;
    }
}
