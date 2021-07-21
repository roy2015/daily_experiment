package com.roy.miscellaneous.guava.event;

import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

/**
 * @author guojun
 * @date 2020/12/24 下午6:02
 */
public class TestEventBus {

    public static void main(String[] args)  {
        EventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(10));
//        EventBus eventBus = new EventBus("123");
        eventBus.register(new CustomSubscriber());
//        eventBus.register(new CustomSubscriber1());
//        eventBus.register(new CustomSubscriber2());

        for (int i = 1; i <= 10; i++) {
            eventBus.post(new CustomEvent().setEventId(i ));
        }

    }
}
