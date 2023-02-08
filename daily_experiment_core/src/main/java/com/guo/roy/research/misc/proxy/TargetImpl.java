package com.guo.roy.research.misc.proxy;

import org.slf4j.LoggerFactory;

/**
 *
 * @author: BG244210
 * Date:    22/10/2018
 * Description:
 *
 * target实现类
 */
public class TargetImpl implements Target {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TargetImpl.class);

    @Override
    public int test(int i) {
        logger.info("{}",i);
        add1("112");
        return  i +1 ;
    }

    public void add1 (String str) {
        logger.info(str);
    }
}