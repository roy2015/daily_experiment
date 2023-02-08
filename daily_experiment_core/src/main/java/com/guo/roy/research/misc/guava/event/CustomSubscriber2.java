package com.guo.roy.research.misc.guava.event;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/1/12 下午7:22
 */

public class CustomSubscriber2 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomSubscriber2.class);

//    @Subscribe
    public void test1 (CustomEvent event) {
        logger.info("{}, {}", this.getClass().getSimpleName(), event.getEventId());
    }
}
