package com.guo.roy.research.misc.proxy;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

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
    public List<String> fire(int i) {
        return  Arrays.asList();
    }

    @Override
    public void seaway(int speed) {
        logger.info("【{}】航速：[{}]" , name, speed);
    }
}