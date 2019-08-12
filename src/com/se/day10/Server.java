package com.se.day10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 将聊天室服务端今天写的内容独立完成一次，
 * 完成后，修改代码，使得服务端可以一直读取
 * 客户端发送过来的每一条消息并输出到控制台。
 *
 * 初始化服务端时，读取当前包中server-config.txt文件的第一行，用该端口进行
 * ServerSocket的初始化。
 */
public class Server {
    public static void main(String[] args) {
        System.out.println("---- 服务器 ----");
        try {
            Server s = new Server();
            Map<String,String> map = s.loadConfig();
            int port = Integer.parseInt(map.get("serverPort"));
            ServerSocket ss = new ServerSocket(port);
            Socket socket = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            String str = null;
            while ((str = br.readLine()) != null){
                System.out.println("客户端说：" + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<String,String> loadConfig(){
        Map<String,String> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("server-config.txt")));
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
