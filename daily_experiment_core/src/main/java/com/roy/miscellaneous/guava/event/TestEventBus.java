package com.roy.miscellaneous.guava.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author guojun
 * @date 2020/12/24 下午6:02
 */
public class TestEventBus {

    public static void main(String[] args) throws InterruptedException {
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
