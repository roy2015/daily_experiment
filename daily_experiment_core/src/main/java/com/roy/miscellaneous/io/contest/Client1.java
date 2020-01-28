package com.roy.miscellaneous.io.contest;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

/**
 * Created by BG244210 on 27/04/2017.
 */
public class Client1 {

    /*发送数据缓冲区*/
    private static ByteBuffer    sBuffer = ByteBuffer.allocate(1024);
    /*接受数据缓冲区*/
    private static ByteBuffer    rBuffer = ByteBuffer.allocate(1024);
    /*服务器端地址*/
    private InetSocketAddress    SERVER;
    private static Selector      selector;
    private static SocketChannel channel;
    private static String        receiveText;
    private static String        sendText;
    private static int           count=0;

    public Client1(int port){
        SERVER = new InetSocketAddress("localhost", port);
        init();
    }
    public void init(){
        try {
           /*
             * 客户端向服务器端发起建立连接请求
             */
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(SERVER);
            /*
             * 轮询监听客户端上注册事件的发生
             */
            while (true) {
                selector.select();
                Set<SelectionKey> keySet = selector.selectedKeys();
                for(final SelectionKey key : keySet){
                    if (key.isConnectable()) {
                        /*
                         * 连接建立事件，已成功连接至服务器
                         */
                        channel = (SocketChannel) key.channel();
                        if (channel.isConnectionPending()) {
                            channel.finishConnect();
                            System.out.println("connect success !");

//                            String fileName = "D:\\test\\123.log";
                            String fileName = "D:\\test\\order-application.log";

                            long startTime = System.currentTimeMillis();
                            File file = new File(fileName);
                            //写入channel
                            transferTo(file, channel);
                            /*ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            byteBuffer.putInt(1);
                            channel.write(byteBuffer);*/
                            System.out.println("大小： " + file.length() + ", 耗时： " + (System.currentTimeMillis() - startTime));
                            channel.close();
                        }
                    }
                };
                keySet.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


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
                    long written = fileChannel.transferTo(transferred, 1000*1000*1000, target);
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

    public static void main(String[] args) throws IOException {
        Client1 client = new Client1(1111);
    }
}
