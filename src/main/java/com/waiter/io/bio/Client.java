package com.waiter.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName Client
 * @Description BIO客户端连接类
 * @Author lizhihui
 * @Date 2019/8/16 16:52
 * @Version 1.0
 */
public class Client {
    private static int DEFAULT_SERVER_PORT = 9999;

    private static String DEFAULT_SERVER_IP = "127.0.0.1";

    public static void send(String expression) {
        send(DEFAULT_SERVER_PORT, expression);
    }

    public static void send(int port, String expression) {
        System.out.println("算术表达式为:" + expression);
        try (Socket socket = new Socket(DEFAULT_SERVER_IP, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);) {
            //向服务器发送expression消息
            out.println(expression);
            //打印出服务器返回的消息
            System.out.println("结果为:" + in.readLine());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
