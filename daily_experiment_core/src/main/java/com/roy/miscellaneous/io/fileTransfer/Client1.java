package com.roy.miscellaneous.io.fileTransfer;

import java.io.*;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class Client1 {

    //java 客户端
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 1111);

        String fileName = "D:\\personal\\code\\github\\demo\\order-application.log";
        long startTime = System.currentTimeMillis();
        transferTo(new File(fileName), socket.getChannel());



        System.out.println("大小： "  + ", 耗时： " + (System.currentTimeMillis() - startTime));

        socket.close();
    }

    public static long transferTo(File f, WritableByteChannel target) throws IOException {
        FileChannel file;
        long position =0;
        long len = f.length();
        long left = len - position;
        long transferred =0;

        // this.open();
        file = (new RandomAccessFile(f, "r")).getChannel();
        while (true) {
            if (left >= 0L && position >= 0L) {
                if (left == 0L) {
                    return 0L;
                } else {

                    long written = file.transferTo(transferred, 10000, target);
                    if (written > 0L) {
                        transferred += written;
                    }
                    left -= written;
                }
            } else {
                throw new IllegalArgumentException("");
            }
        }

    }
}
