package com.roy.research.io;

import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by apple on 2019/10/9.
 */
public class TestFileChannel {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestFileChannel.class);

    public static void test() {
        try {
            ReadableByteChannel byteChannel = Channels.newChannel(
                    new FileInputStream(new File("/Users/apple/guojun/test/docker相关.txt")));
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1000);
            int bytesRead = byteChannel.read(byteBuffer);
            while (bytesRead != -1) {
            /*设置读，因为写过来，需要flip才能读*/
                byteBuffer.flip();
			/*开始读取*/
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
                bytesRead = byteChannel.read(byteBuffer);
            }

        } catch (FileNotFoundException e) {
            logger.info(e.getMessage(), e);
        } catch (IOException e) {
            logger.info(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
