package com.roy.miscellaneous.spi;

import com.alibaba.dubbo.common.extension.SPI;

@SPI("wechat")
public interface PayService {

    void pay();
}
