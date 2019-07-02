package com.roy.miscellaneous.proxy;

/**
 *
 * @author: BG244210
 * Date:    22/10/2018
 * Description:
 *
 * target实现类
 */
public class TargetImpl implements Target {


    @Override
    public int test(int i) {
        System.out.println(i);
        return  i +1 ;
    }
}