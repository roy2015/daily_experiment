package com.roy.miscellaneous.spi;

import org.slf4j.LoggerFactory;

/**
 * 微信支付
 */
public class WechatPayService implements PayService {
    private static final org.slf4j.Logger logger =
            LoggerFactory.getLogger(WechatPayService.class);

    @Override
    public void pay() {
        logger.debug("微信支付");
    }
}
