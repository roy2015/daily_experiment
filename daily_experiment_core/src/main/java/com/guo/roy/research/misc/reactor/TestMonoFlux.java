package com.guo.roy.research.misc.reactor;

import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestMonoFlux {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestMonoFlux.class);


    static class Solution {
        public  void test() {
            Flux.just("Hello", "World").subscribe(System.out::println);

            Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);

            Flux.empty().subscribe(System.out::println);

            Flux.range(1, 10).subscribe(System.out::println);

            Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);


        }

    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
