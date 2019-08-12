package com.se.day06;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 编写一个程序，将当前目录下所有员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入集合。然后排序该集合，按照员工的年龄排序，年龄大的靠前，年龄小
 * 的靠后。排序完毕后输出结果。
 */
public class Test11 {
    public static Emp emp;
    public static void main(String[] args) {
        Test11 t = new Test11();
        File dir = new File(".");
        List<Emp> list = t.loadEmp(dir);
        Collections.sort(list, new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for(Emp e : list){
            System.out.println(e);
        }
    }
    // 读取员工文件
    public List<Emp> loadEmp(File dir){
        List<Emp> list = new ArrayList<>();
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().endsWith("emp");
            }
        });
        for(File file : files){
            list.add(empInfo(file));
        }
        return list;
    }
    // 从文件中解析出员工信息
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
