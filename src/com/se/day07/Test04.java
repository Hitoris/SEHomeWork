package com.se.day07;

import java.io.*;
import java.util.*;

/**
 * 读取当前项目根目录下所有后缀为.obj的文件，将这些Emp对象读取出来
 * 并存入到一个List集合中，然后按照员工工资从多到少的顺序依次输出员工信息
 */
public class Test04 {
    public static Emp emp;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Test04 t = new Test04();
        File dir = new File(".");
        List<Emp> list = t.loadEmps(dir);
        Collections.sort(list, new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return o2.getSalary() - o1.getSalary();
            }
        });
        for(Emp e : list){
            System.out.println(e);
        }
    }
    // 读取所有obj文件
    public List<Emp> loadEmps(File dir) throws IOException, ClassNotFoundException {
        // 读取当前项目根目录下所有后缀为.obj的文件
        File[] objs = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith("obj");
            }
        });
        List<Emp> list = new ArrayList<>();
        for(File file : objs){
            list.add(loadEmp(file));
        }
        return list;
    }
    // 解析出file文件里的员工信息
    public Emp loadEmp(File file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        emp = (Emp) ois.readObject();
        ois.close();
        return emp;
    }
}
