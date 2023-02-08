package com.roy.research.pattern.factory;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/5/4.
 */
public class IntelCpu implements CPU {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IntelCpu.class);
    private static int PIN = 30;

    @Override
    public void calculate() {
        logger.debug("{}, pins:[{}]", IntelCpu.class.getName(), PIN);
    }
}
