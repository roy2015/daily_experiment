package com.roy.miscellaneous.io.contest;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 比赛题目:   用JAVA语言实现一个网络文件传输程序， Demo参考：https://gitlab.tuhu.cn/wuhanjishubiwu/demo
 * 	比赛时间:  即日起至2019年12月25日
 *         限制条件：只能用TCP协议， 不限制语言，但只能用语言标准库，(如:java只能用java sdk，nodejs，只能本身的api，不能用第三方模块）， 要传输的文件大小2G，用demo中的 order-application.log文件做传输
 *         评分主要考量点： 编码规范， 可读性，可扩展性，稳定性，性能等
 *         设计建议：
 *         1.  减少拷贝，建议采用mmap或sendfile方式
 *         2.  考虑 windows和linux不同
 *         3.  考虑网络异常，支持断点续传
 *         4.  高效网络传输
 *         5.  cpu最大化利用（排除cpu copy）
 *         6.  可以自定义压缩，不限制压缩算法，但需要实现解压
 *        7.  评判标准传输时间最短
 */
public class Server {

    // java 的服务器
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1111);

        long startTime = System.currentTimeMillis();
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            try {
                byte[] byteArray = new byte[4096];
                String path = "D:\\test\\456.log";
                FileOutputStream fos=new FileOutputStream(path, false);


                while (true) {
                    int readCount = dataInputStream.read(byteArray, 0, byteArray.length);
                    if (-1 == readCount) {
                        break;
                    } else {
                        fos.write(byteArray, 0 , readCount);
                    }
                }
                fos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        System.out.println("1耗时： " + (System.currentTimeMillis() - startTime));

    }
}
