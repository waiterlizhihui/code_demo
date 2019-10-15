package com.waiter.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName ServerNormal
 * @Description 服务端监听类
 * @Author lizhihui
 * @Date 2019/8/16 16:17
 * @Version 1.0
 */
public final class ServerNormal {
    private static int DEFAULT_PORT = 9999;

    private static ServerSocket serverSocket;

    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }

    public synchronized static void start(int port) throws IOException {
        if (serverSocket != null) {
            return;
        }

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务器已经启动，端口号：" + port);
            //通过无限循环监听客户端连接，如果没有客户端接入，将阻塞在accept操作上
            while (true) {
                Socket socket = serverSocket.accept();
                //如果有客户端接入，则会执行下面的代码，创建一个新得线程处理这条Socket连接
                new Thread(new ServerHandler(socket)).start();
            }
        } finally {
            if (serverSocket != null) {
                System.out.println("服务器关闭。");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
