package com.se.day05;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 创建一个队列，存入Integer类型元素1,2,3,4,5
 * 然后遍历队列并输出每个元素
 */
public class Test01 {
    public static void main(String[] args){
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        while (q.size() > 0){
            Integer i = q.poll();
            System.out.println(i);
        }
    }
}
