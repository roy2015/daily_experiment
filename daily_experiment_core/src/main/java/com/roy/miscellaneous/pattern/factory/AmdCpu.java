package com.roy.miscellaneous.pattern.factory;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/5/4.
 *
 *
 * AMD CPU实现
 */
public class AmdCpu implements CPU {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AmdCpu.class);
    private static int PIN = 20;

    @Override
    public void calculate() {
        logger.debug("{}, pins:[{}]", AmdCpu.class.getName(), PIN);
    }
}
