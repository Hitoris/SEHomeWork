package com.se.day05;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 有下列字符串:
 * 销售:张三;财务:李四;销售:王五;财务:赵六;程序:mike;程序:jerry;美工:jackson;前端:green;前端:nick;程序:钱七;销售:alice
 * 分析上述字符串然后统计每个职位总共多少人?
 * 使用Map保存统计的结果，其中key:职位,value为该职位人数
 * 然后分别输出各职位的名称(keySet),各职位人数(entrySet)
 */
public class Test05 {
    public static void main(String[] args) {
        String str = "销售:张三;财务:李四;销售:王五;财务:赵六;程序:mike;程序:jerry;美工:jackson;前端:green;前端:nick;程序:钱七;销售:alice";
        String[] ss = str.split(";");
        Map<String,Integer> map = new HashMap<>();
        for(String s : ss){
            String[] position = s.split(":");
            if(map.containsKey(position[0])){
                map.put(position[0],map.get(position[0])+1);
            } else {
                map.put(position[0],1);
            }
        }
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            System.out.println("职位名称："+key);
        }
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for(Map.Entry<String,Integer> entry : entrySet){
            System.out.println("职位："+entry.getKey()+" 职位人数："+entry.getValue());
        }
    }
}
