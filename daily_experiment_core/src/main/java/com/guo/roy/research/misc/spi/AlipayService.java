package com.guo.roy.research.misc.spi;

import org.slf4j.LoggerFactory;

/**
 * 支付宝支付
 */
public class AlipayService implements PayService {
    private static final org.slf4j.Logger logger =
            LoggerFactory.getLogger(AlipayService.class);

    @Override
    public void pay() {
        logger.debug("支付宝支付");
    }
}