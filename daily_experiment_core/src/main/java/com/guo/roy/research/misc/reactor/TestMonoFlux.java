package com.guo.roy.research.misc.reactor;

import lombok.Data;
import org.slf4j.LoggerFactory;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/**
 * @author guojun
 * @date 2021/1/21 10:40
 *
 *
 * Flux,Mono都是publisher发布者， flux发射多个，mono发射一个
 */
public class TestMonoFlux {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestMonoFlux.class);


    static class Solution {
        public  void testFlux() {
            Flux.just("Hello", "World").subscribe(logger::info);

            Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(s-> logger.info(String.valueOf(s)));

            Flux.empty().subscribe(s-> logger.info(String.valueOf(s)));

            Flux.range(1, 10).subscribe(s-> logger.info(String.valueOf(s)));

            logger.info("==========");

            Flux.interval(Duration.of(100, ChronoUnit.MILLIS)).subscribe(System.out::println);


        }

        public void testFlux1() throws InterruptedException {
            Button button = new Button();

            Flux.<Integer>create(emitter -> {
                button.actionListeners.add(k -> emitter.next(k));

            }).subscribe(s -> logger.info("{}", s));

            TimeUnit.SECONDS.sleep(1);
            button.click(1111);
        }

        @Data
        static class Button {
            private List<Consumer<Integer>> actionListeners = new ArrayList<>();

            public void click(Integer a) {
                actionListeners.forEach(k-> k.accept(a));
            }
        }

        public void testMono() {
            Mono.just("23").subscribe(s -> System.out.println(s));
            Mono.create( monoSink -> monoSink.success(1)).subscribe(System.out::println);
        }

    }

    public static void main(String[] args) throws InterruptedException {
//        new Solution().testMono();
//        new Solution().testFlux();
//        TimeUnit.SECONDS.sleep(10);
        new Solution().testFlux1();
    }
}
