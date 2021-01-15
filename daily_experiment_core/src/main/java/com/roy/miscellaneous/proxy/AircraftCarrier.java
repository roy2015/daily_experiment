package com.roy.miscellaneous.proxy;

import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 *
 * @author: BG244210
 * Date:    22/10/2018
 * Description:
 *
 * 航母
 */
//@Order(1)
public class AircraftCarrier implements Warship {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AircraftCarrier.class);

    private String name;

    public AircraftCarrier(String name) {
        this.name = name;
    }

    @Override
    public String getWarshipName() {
        return name;
    }

    @Override
    public int fire(int i) {
        System.out.println("航母" + i);
        return  i +1 ;
    }

    @Override
    public void seaway(int speed) {
//        logger.info("【{}】航速：[{}]" , name, speed);
    }
}