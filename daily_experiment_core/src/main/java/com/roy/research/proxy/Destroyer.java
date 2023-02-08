package com.roy.research.proxy;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author guojun
 * @date 2021/1/15 下午3:37
 *
 * 驱逐舰
 */
public class Destroyer implements Warship{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Destroyer.class);

    private String name;

    public Destroyer(String name) {
        this.name = name;
    }

    @Override
    public String getWarshipName() {
        return name;
    }

    @Override
    public List<String> fire(int i) {
        return  Arrays.asList(
                "击中美军阿利-伯克级 CDG-100",
                "击中美军阿利-伯克级 CDG-101",
                "击中美军阿利-伯克级 CDG-102");
    }

    @Override
    public void seaway(int speed) {
        logger.info("【{}】航速：[{}]" , name, speed);
    }
}
