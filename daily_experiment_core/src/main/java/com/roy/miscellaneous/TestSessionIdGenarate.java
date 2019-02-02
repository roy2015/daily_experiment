package com.roy.miscellaneous;

import com.roy.miscellaneous.targetObject.SessionIdUtil;
import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/2/2.
 */
public class TestSessionIdGenarate {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSessionIdGenarate.class);

    public static void test() {
        logger.info(SessionIdUtil.getInstance().generate());
    }



}
