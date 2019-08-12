package com.se.day01;

import java.util.Random;
import java.util.Scanner;

/**
 * 随机生成一个5位的英文字母验证码(大小写混搭)
 *  * 然后将该验证码输出给用户，然后要求用户输入该验证码，大小写不限制。
 *  * 然后判定用户输入的验证码是否有效(无论用户输入大小写，只要字母都正确即可)。
 */
public class Test05 {
    public static void main(String[] args){
        String str = new Test05().randomW();
        System.out.println(str);
        Scanner console = new Scanner(System.in);
        System.out.println("请输入验证码：");
        String s = console.nextLine();
        if(s.equalsIgnoreCase(str)){
            System.out.println("输入的验证码有效");
        } else{
            System.out.println("输入的验证码无效");
        }
    }
    public String randomW(){
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 5;i ++){
            if(r.nextInt(2) == 1){
                sb.append((char)('a'+r.nextInt(26)));
            } else{
                sb.append((char)('A'+r.nextInt(26)));
            }
        }
        return sb.toString();
    }
}
