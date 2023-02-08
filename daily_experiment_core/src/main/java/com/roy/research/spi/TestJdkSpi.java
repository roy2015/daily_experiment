package com.roy.research.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestJdkSpi {

    public void testJdkSpi() {
        ServiceLoader<PayService> serviceLoader = ServiceLoader.load(PayService.class);
        Iterator<PayService> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            PayService payService = iterator.next();
            payService.pay();
        }

    }

}
