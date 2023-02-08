package com.roy.research.proxy;

import java.util.List;

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

    /**
     * 开火射击
     * @param i
     * @return 返回几种目标情况
     */
    List<String> fire(int i);

    /**
     * 巡航
     * @param speed
     */
    void seaway(int speed);
}