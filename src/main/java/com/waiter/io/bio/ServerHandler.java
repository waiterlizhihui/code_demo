package com.waiter.io.bio;

import com.waiter.io.utils.Calculator;

import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ClassName ServerHandler
 * @Description 服务端数据处理线程
 * @Author lizhihui
 * @Date 2019/8/16 16:24
 * @Version 1.0
 */
public class ServerHandler implements Runnable {
    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            String expression;
            String result;
            while (true) {
                if ((expression = in.readLine()) == null) {
                    break;
                }

                System.out.println("服务器收到消息:" + expression);
                try {
                    result = Calculator.cal(expression).toString();
                } catch (ScriptException e) {
                    result = "计算错误：" + e.getMessage();
                }
                out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
