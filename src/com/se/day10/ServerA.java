package com.se.day10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器，先向客户端发送信息，再接收客户端发来的信息
 */
public class ServerA {
    public static void main(String[] args) {
        System.out.println("----- 服务器 -----");
        try {
            // 创建服务器套接字
            ServerSocket ss = new ServerSocket(222);
            Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            while (true){
                Scanner console = new Scanner(System.in);
                // 向客户端发送信息
                String str = console.nextLine();
                pw.println(str);
                str = br.readLine();
                System.out.println("客户端说：" + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
