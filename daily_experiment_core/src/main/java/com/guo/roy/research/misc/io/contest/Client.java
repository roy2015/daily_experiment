package com.guo.roy.research.misc.io.contest;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Client {

    //java 客户端
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 1111);

//        String fileName = "D:\\personal\\code\\github\\demo\\order-application.log";
        String fileName = "D:\\test\\123.log";
        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[1000*1000*1000];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();

        while ((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("1大小： " + total + ", 耗时： " + (System.currentTimeMillis() - startTime));

        //顺序不能乱
        inputStream.close();
        socket.close();
        dataOutputStream.close();
    }
}
