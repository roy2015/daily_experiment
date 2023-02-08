package com.guo.roy.research.misc.pattern.factory;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/5/4.
 *
 * MSI 主板
 */
public class MSIMainBoard implements MainBoard{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MSIMainBoard.class);
    private static int CPU_PIN = 20;

    @Override
    public void installCpu() {
        logger.debug("{}, cpu pins:[{}]", MSIMainBoard.class.getName(), CPU_PIN);
    }
}
