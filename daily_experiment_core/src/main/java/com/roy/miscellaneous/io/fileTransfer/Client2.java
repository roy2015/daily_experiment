package com.roy.miscellaneous.io.fileTransfer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

/**
 * Created by BG244210 on 27/04/2017.
 */
public class Client2 {
    public void client(String fileName, String ip , int port) {
        try {
            /*发送数据缓冲区*/
            ByteBuffer sendBuffer = ByteBuffer.allocate(8);
            /*接收数据缓冲区*/
            ByteBuffer revBuffer = ByteBuffer.allocate(8);
            /*服务器端地址*/
            InetSocketAddress ipPort;
            Selector selector;
            SocketChannel clientChannel;
            File file;
            String start = "start";

            file = new File(fileName);
            ipPort = new InetSocketAddress(ip, port);

            long fileLen = file.length();
            /*
             * 客户端向服务器端发起建立连接请求
             */
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT, ByteBuffer.allocate(1024 * 1024 * 1024));
            socketChannel.connect(ipPort);
            /*
             * 轮询监听客户端上注册事件的发生
             */
            while (true) {
                selector.select();
                Set<SelectionKey> keySet = selector.selectedKeys();
                for (final SelectionKey key : keySet) {
                    if (key.isConnectable()) {
                        /*
                         * 连接建立事件，已成功连接至服务器
                         */
                        clientChannel = (SocketChannel) key.channel();
                        if (clientChannel.isConnectionPending()) {
                            clientChannel.finishConnect();
                            System.out.println("connect success !");
                            try {
                                sendBuffer.clear();
                                /*
                                 * 未注册WRITE事件，因为大部分时间channel都是可以写的
                                 */
                                sendBuffer.putLong(fileLen);
                                sendBuffer.flip();
                                clientChannel.write(sendBuffer);
                                clientChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024 * 1024 * 1024));
                            } catch (IOException e) {
                                e.printStackTrace();
                                break;
                            }
                        }
                    } else if (key.isReadable()) {
                        clientChannel = (SocketChannel) key.channel();
                        revBuffer.clear();
                        clientChannel.read(revBuffer);
                        revBuffer.rewind();
                        byte[] bytes = new byte[10];
                        revBuffer.get(bytes, 0 , start.getBytes("utf-8").length);
                        if ("start".equalsIgnoreCase(new String(bytes, 0, start.length(), "utf-8"))) {//收到信号
                            //开始传文件了。。。
                            long startTime = System.currentTimeMillis();
                            //写入channel
                            transferTo(file, clientChannel);
                            System.out.println(
                                    "大小： " + file.length() + ", 耗时： " + (System.currentTimeMillis() - startTime));
                            clientChannel.close();
                        }
                    } else {
                    }
                }
                ;
                keySet.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送文件
     * @param f
     * @param target
     * @return
     * @throws IOException
     */
    public static long transferTo(File f, WritableByteChannel target) throws IOException {
        FileChannel fileChannel;
        long len = f.length();//文件长度
        long left = len;//剩余字节
        long transferred = 0;//已传输
        fileChannel = (new RandomAccessFile(f, "r")).getChannel();
        while (true) {
            if (left >= 0L) {
                if (left == 0L) {
                    return 0L;
                } else {
                    long written = fileChannel.transferTo(transferred, 1024 * 1024 * 1024, target);
                    if (written > 0L) {
                        transferred += written;
                    }
                    left -= written;
                    System.out.println(String.format("传输数据大小[%s]", written / 1024d / 1024d));
                }
            } else {
                throw new IllegalArgumentException("");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "D:\\test\\order-application.log";
//        String path = "D:\\test\\123.log";
        new Client2().client(path, "172.16.244.94", 1111);
    }
}
