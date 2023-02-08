package com.guo.roy.research.misc.pattern.factory;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/5/4.
 *
 * GA 主板
 */
public class GAMainBoard implements MainBoard{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GAMainBoard.class);
    private static int CPU_PIN = 30;

    @Override
    public void installCpu() {
        logger.debug("{}, cpu pins:[{}]", GAMainBoard.class.getName(), CPU_PIN);
    }
}
