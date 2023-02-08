package com.guo.roy.research.misc.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestDubboSpi {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestDubboSpi.class);


    static class Solution {

        private void testDubboSpi() {
            ExtensionLoader<PayService> extensionLoader = ExtensionLoader.getExtensionLoader(PayService.class);
            PayService alipay = extensionLoader.getExtension("alipay");
            alipay.pay();
            PayService defaultExtension = extensionLoader.getDefaultExtension();
            defaultExtension.pay();

        }

    }

    public static void main(String[] args) {
        new Solution().testDubboSpi();
        logger.info("");
    }
}
