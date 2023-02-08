package com.roy.research.pattern.singleton;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/3/22 下午3:41
 *
 * mock对象
 */
public class TestEnumSingleton {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestEnumSingleton.class);

    public static void main(String[] args) {
        SingletonObjectHolder mockObject1 = SingletonObjectHolder.MOCK_OBJECT;
        SingletonObjectHolder mockObject2 = SingletonObjectHolder.MOCK_OBJECT;

        logger.info("{}", mockObject1.getMockObject() == mockObject2.getMockObject());
    }
}
