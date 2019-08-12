package com.se.day10;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 将聊天室客户端今天写的内容独立完成一次，
 * 完成后，修改代码，使聊天室可以实现用户
 * 随意在控制台输入内容并发送给服务端。
 *
 * 在构造方法中初始化Socket时，服务端的地址与端口通过读取当前包中的config.txt
 * 文件的两行内容得到，并依读取到的值初始化Socket。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("---- 客户端 ----");
        Client c = new Client();
        Map<String,String> config = c.loadConfig();
        String serverHost = config.get("serverHost");
        int port = Integer.parseInt(config.get("serverPort"));
        try {
            Socket s = new Socket(serverHost,port);
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            Scanner console = new Scanner(System.in);
            // 不断给服务器发送信息
            while (true){
                String str = console.nextLine();
                pw.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<String,String> loadConfig(){
        Map<String,String> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("config.txt")));
            String str = null;
            while ((str = br.readLine()) != null){
                String[] s = str.split("=");
                String key = s[0];
                String value = s[1];
                map.put(key,value);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
