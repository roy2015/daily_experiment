package com.guo.roy.research.testing;

import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by apple on 2019/4/10.
 *
 * 数字运算
 */
public class TestDigitalArithmetic {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestDigitalArithmetic.class);

    public void testDouble() {
        logger.debug("{}", 2.0-1.1);
    }

    public void testBigDecimal() {
        logger.debug("{}",  new Double(0.9));
        testDouble();
        double a = 2.0, b = 1.1;
        BigDecimal aDecimal = new BigDecimal(a);
        BigDecimal bDecimal = new BigDecimal(b);

        BigDecimal cDecimal = aDecimal.subtract(bDecimal, new MathContext(5, RoundingMode.HALF_UP));

        logger.debug("{}", cDecimal);
    }

}
