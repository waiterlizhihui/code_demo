package com.waiter.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ServerBetter
 * @Description 对ServerNormal的优化，引入了SeverHandler的线程池，避免每次有消息时都需要新开一个线程来处理
 * @Author lizhihui
 * @Date 2019/8/16 17:43
 * @Version 1.0
 */
public class ServerBetter {
    private static int DEFAULT_PORT = 9999;

    private static ServerSocket serverSocket;

    private static ExecutorService executorService = Executors.newFixedThreadPool(60);

    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }

    public synchronized static void start(int port) throws IOException {
        if (serverSocket != null) {
            return;
        }

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务器已启动，端口号：" + port);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                System.out.println("服务器关闭");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
