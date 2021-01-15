package com.roy.miscellaneous.proxy;

import org.slf4j.LoggerFactory;

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
    public int fire(int i) {
        System.out.println("驱逐舰" + i);
        return  i +1 ;
    }

    @Override
    public void seaway(int speed) {
//        logger.info("【{}】航速：[{}]" , name, speed);
    }
}
