package com.guo.roy.research.misc.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestDubboSpi {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestDubboSpi.class);


    static class Solution {

        private void testDubboSpi() {
            ExtensionLoader<PayService> extensionLoader = ExtensionLoader.getExtensionLoader(PayService.class);
//            //按name获取扩展
//            PayService alipay = extensionLoader.getExtension("alipay");
//            alipay.pay();
//            //默认扩展
//            PayService defaultExtension = extensionLoader.getDefaultExtension();
//            defaultExtension.pay();
            //自适应扩展
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("type", "alipay");
            List<PayService> activateExtension = extensionLoader.getActivateExtension(new URL("http", "localhost", 8080, paramMap), "type");
            activateExtension.get(0).pay();

//            extensionLoader.getAdaptiveExtension().adpPay(URL.valueOf("dubbo://localhost:8080/type=alipay"));


        }

    }

    public static void main(String[] args) {
        new Solution().testDubboSpi();
        logger.info("");
    }
}
