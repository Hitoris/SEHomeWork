package com.se.day10;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端，先接收服务器发来的信息，再向服务器发送信息
 */
public class ClientA {
    public static void main(String[] args) {
        System.out.println("----- 客户端 -----");
        try {
            Socket s = new Socket("127.0.0.1",222);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            while (true){
                Scanner console = new Scanner(System.in);
                // 先读取服务器发送过来的信息
                String str = br.readLine();
                System.out.println("服务器说：" + str);
                // 再向服务器发送信息
                str = console.nextLine();
                pw.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
