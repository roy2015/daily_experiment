package com.guo.roy.research.misc.spi;

import com.alibaba.dubbo.common.URL;
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

    @Override
    public void adpPay(URL url) {
        logger.debug("adaptive微信支付");
    }


}
