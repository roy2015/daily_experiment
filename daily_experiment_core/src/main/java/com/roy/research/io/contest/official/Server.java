package com.roy.research.io.contest.official;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 比赛题目:   用JAVA语言实现一个网络文件传输程序， Demo参考：https://gitlab.tuhu.cn/wuhanjishubiwu/demo
 * 比赛时间:  即日起至2019年12月25日
 * 限制条件：只能用TCP协议， 不限制语言，但只能用语言标准库，(如:java只能用java sdk，nodejs，只能本身的api，不能用第三方模块）， 要传输的文件大小2G，用demo中的 order-application.log文件做传输
 * 评分主要考量点： 编码规范， 可读性，可扩展性，稳定性，性能等
 * 设计建议：
 * 1.  减少拷贝，建议采用mmap或sendfile方式
 * 2.  考虑 windows和linux不同
 * 3.  考虑网络异常，支持断点续传
 * 4.  高效网络传输
 * 5.  cpu最大化利用（排除cpu copy）
 * 6.  可以自定义压缩，不限制压缩算法，但需要实现解压
 * 7.  评判标准传输时间最短
 */
public class Server {
    /**
     * socketChannel -> fileChannel
     * @param fileChannel
     * @param source
     * @param originPos
     * @return
     * @throws IOException
     */
    public static long transferFrom(FileChannel fileChannel, ReadableByteChannel source, long originPos, long fileLen)
            throws IOException {
        long written = 0L;
        long position = originPos;
        while (true) {
            written = fileChannel.transferFrom(source, position, fileLen);
            if (written > 0L) {
                position += written;
            } else if (written == 0) {
                System.out.println(String.format("本轮接收数据【%s】K,已接收【%s】M", (position - originPos)/1024d ,
                        position / 1024d / 1024d));
                return position;
            }
            System.out.println(String.format("此次接收数据【%s】K,已接收【%s】M", written/1024d ,position / 1024d / 1024d));
        }
    }

    public void serve(int port, File file) throws IOException {
        String start = "start";
        ByteBuffer rBuffer = ByteBuffer.allocate(20);
        FileChannel fileChannel = (new RandomAccessFile(file, "rw")).getChannel();
        boolean isStart = false;//开始接收文件
        System.out.println(String.format("监听连接，端口 %s ", port));
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket ss = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        ss.bind(address);
        serverChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        long startTime = 0;
        long fileLen = 0;
        long position = 0;
        while (true) {
            try {
                selector.select();
            } catch (IOException ex) {
                ex.printStackTrace();
                // handle in a proper way
                break;
            }
            Set readyKeys = selector.selectedKeys();
            Iterator iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()) {//建立连接
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        System.out.println(String.format("Accepted connection from {%s}，时间 [%s]", client, new Date()));
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {//读数据
                        if (!isStart) {
                            SocketChannel clientChannel = (SocketChannel) key.channel();
                            int count = clientChannel.read(rBuffer);
                            if (count > 0) {
                                rBuffer.rewind();
                                long aLong = rBuffer.getLong();
                                fileLen = aLong;
                                System.out.println(String.format("文件大小[%s]", fileLen));
                                isStart = true;
                                rBuffer.clear();
                                rBuffer.put(start.getBytes("utf-8"));
                                rBuffer.flip();
                                System.out.println(String.format("发送开始传输信号:[%s]: 请开始", start ));
                                startTime = System.currentTimeMillis();
                                clientChannel.write(rBuffer);
                            }
                        } else {
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            System.out.println(String.format("开始接收文件，开始时间[%s], 距离开始时间[%s]", new Date(),
                                    System.currentTimeMillis() - startTime));
                            position = transferFrom(fileChannel, socketChannel, position, fileLen);
                            if (position >= fileLen) {
                                System.out.println(String.format("接收文件完毕，结束时间[%s], 距离开始时间耗时 [%s]",
                                        new Date(), System.currentTimeMillis() - startTime));
                                fileChannel.close();
                            }
                        }
                    }
                } catch (IOException ex) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException cex) {
                    }
                }
            }
        }
    }

    // java 的服务器
    public static void main(String[] args) throws Exception {
        try {
//            String path = "D:\\test\\456.log";
            String path = "/Users/apple/guojun/test/456.log";
            new Server().serve(1111, new File(path));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
