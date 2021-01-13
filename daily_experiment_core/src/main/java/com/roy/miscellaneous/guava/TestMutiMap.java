package com.roy.miscellaneous.guava;

import java.util.concurrent.Executors;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.roy.miscellaneous.guava.event.*;
import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/24 下午6:02
 */
public class TestMutiMap {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestMutiMap.class);

    public static void main(String[] args) {
        Multimap<String , Animal> todoMap = ArrayListMultimap.create();
        todoMap.put ("1", new Animal().setAge(1).setName("John"));
        todoMap.put("1", new Animal().setAge(2).setName("John2"));
        todoMap.put("2", new Animal().setAge(21).setName("John21"));
        logger.info("{}", todoMap.containsKey("1"));
        logger.info("{}",todoMap.get("1"));


        Multimap<String, Integer> multimap1 =
          new ImmutableMultimap.Builder<String, Integer>()
                          .put("one", 1)
                          .putAll("several", 1, 2, 3)
                          .putAll("several", 1,2)
                          .putAll("many", 1, 2, 3, 4, 5)
                          .build();
        logger.info("{}", multimap1);


    }

}
