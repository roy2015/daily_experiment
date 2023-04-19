package com.guo.roy.research.misc.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.util.internal.PlatformDependent;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author guojun
 * @date 2021/6/11
 * 测试jdk和netty的ByteBuffer
 */
public class TestByteBuf {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestByteBuf.class);


    static class Solution {
        /**
         * netty的ByteBuf
         */
        public  void testByteBuf() {
            UnpooledByteBufAllocator bufAllocator = new UnpooledByteBufAllocator(PlatformDependent.directBufferPreferred());
            ByteBuf byteBuf = bufAllocator.heapBuffer(10, 100);
            byteBuf.writeInt(3);
            byteBuf.writeBytes("ab".getBytes(StandardCharsets.UTF_8));
            logger.info("{}",byteBuf.readableBytes());
            logger.info("{}", byteBuf.readInt());
            logger.info("{}", byteBuf.skipBytes(1));
            byte[] bytes = new byte[byteBuf.readableBytes()];
            logger.info("{}", byteBuf.readBytes(bytes));
            logger.info("{}", new String(bytes));
            byteBuf.writeBytes("abcdefghijklmnopqrstuvwxyz".getBytes(StandardCharsets.UTF_8));
            bytes = new byte[byteBuf.readableBytes()];
            logger.info("{}", byteBuf.readBytes(bytes));
            logger.info("{}", new String(bytes));
        }

        /**
         * jdk的 Bytebuffer
         * limit,position, mark
         */
        public  void testByteBuffer() {
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            byteBuffer.putInt(3);
            byteBuffer.put("ab".getBytes(StandardCharsets.UTF_8), 0, 2);
            byteBuffer.flip();


            logger.info("{}", byteBuffer.getInt());
            logger.info("{}",byteBuffer.get());
            byte[] bytes = new byte[byteBuffer.remaining()];
            byteBuffer.get(bytes);
            logger.info("{}", new String(bytes));
        }

    }

    public static void main(String[] args) {
        new Solution().testByteBuf();
//        new Solution().testByteBuffer();
    }
}
