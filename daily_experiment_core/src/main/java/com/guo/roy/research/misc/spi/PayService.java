package com.guo.roy.research.misc.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("wechat")
public interface PayService {

    void pay();

    @Adaptive("type")
    void adpPay(URL url);
}
