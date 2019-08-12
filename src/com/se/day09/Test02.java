package com.se.day09;

/**
 * 使用线程方式二创建两个线程:分别输出1000次，你好和再见
 */
public class Test02 {
    public static void main(String[] args) {
        Thread t3 = new Thread(new MyThread3());
        Thread t4 = new Thread(new MyThread4());
        t3.start();
        t4.start();
    }
}
class MyThread3 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i < 1000;i ++){
            System.out.println("你好！");
        }
    }
}
class MyThread4 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i < 1000;i ++){
            System.out.println("再见！");
        }
    }
}