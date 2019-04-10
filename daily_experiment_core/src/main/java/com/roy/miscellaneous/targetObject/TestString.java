package com.roy.miscellaneous.targetObject;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/4/8.
 */
public class TestString {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestString.class);
    public void testStringEqual() {
        String s1 = "123", s2 = "123";
        logger.debug("{}",s1 == s2);
        logger.debug("{}",s1.equals(s2));

    }
}
