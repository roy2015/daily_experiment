package com.guo.roy.research.misc.netty;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import io.netty.buffer.PooledByteBufAllocator;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.util.internal.PlatformDependent;

/**
 * @author guojun
 * @date 2023/10/16
 * 测试netty的chunk分配page底层原理   memoryMap
 *  {@link io.netty.buffer.PoolChunk }
 */
public class TestPoolChunk {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestPoolChunk.class);


    static class Solution {
        public void testPoolChunk() {
            ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer(1024  * 16);//16k
            ByteBuf byteBuf1 = PooledByteBufAllocator.DEFAULT.directBuffer(1024  * 16);//16k
            ByteBuf byteBuf2 = PooledByteBufAllocator.DEFAULT.directBuffer(1024  * 16);//16k
        }

    }

    public static void main(String[] args) {
        new Solution().testPoolChunk();
    }
}
