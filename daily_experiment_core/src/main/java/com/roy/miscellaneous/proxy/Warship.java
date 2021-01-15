package com.roy.miscellaneous.proxy;

import org.springframework.core.annotation.Order;

/**
 * Created by BG244210 on 22/10/2018.
 * modify on 2021/01/15
 *
 * 军舰
 *
 */

public interface Warship {

    /**
     * 战舰名称
     * @return
     */
    String getWarshipName();

    int fire(int i);

    /**
     * 航行
     * @param speed
     */
    void seaway(int speed);
}