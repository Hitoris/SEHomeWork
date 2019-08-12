package com.se.day05;

import java.util.*;

/**
 *创建一个Map，保存某个学生的成绩:
 *在控制台输入该学生成绩，格式:
 *科目:成绩;科目:成绩;...
 *例如:
 *语文:99;数学:98;英语:97;物理:96;化学:95
 *然后输出物理的成绩。
 *然后将化学的成绩设置为96
 *然后删除英语这一项。
 *然后遍历该Map分别按照遍历key，Entry，value
 *的形式输出该Map信息。
 */
public class Test04 {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("请输入该学生的考试科目数量：");
        int num = Integer.parseInt(console.nextLine());
        Map<String,Integer> map = new HashMap<String,Integer>();
        System.out.println("请输入考试科目与成绩：");
        for(int i = 0;i < num;i ++){
            String subject = console.nextLine();
            int score = Integer.parseInt(console.nextLine());
            map.put(subject,score);
        }
        int physics = map.get("物理");
        System.out.println("物理成绩为：" + physics);
        map.put("化学",96);
        map.remove("英语");
        // 遍历key
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            System.out.println(key);
        }
        // 遍历Entry
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for(Map.Entry<String,Integer> entry : entrySet){
            System.out.println("科目："+entry.getKey()+"  成绩："+entry.getValue());
        }
        // 遍历value
        Collection<Integer> valueSet = map.values();
        for(Integer value : valueSet){
            System.out.println(value);
        }
    }
}
