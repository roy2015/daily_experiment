package com.roy.miscellaneous.spi;

import org.slf4j.LoggerFactory;

public class WeichatPayService implements PayService {
    private static final org.slf4j.Logger logger =
            LoggerFactory.getLogger(WeichatPayService.class);

    @Override
    public void pay() {
        logger.debug("微信支付");
    }
}
