package com.roy.miscellaneous.rxJava;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 模拟滑动窗口计数
 * 一个bucket代表5秒， windows大小是3个bucket, windwo移动步长是一个bucket(5秒)
 * Created by albon on 17/6/24.
 */
public class RollingWindowTest {
    private static final Logger logger = LoggerFactory.getLogger(RollingWindowTest.class);
    private static final int THRESHOLD = 50;
    private static final int BUCKET_SIZE_IN_SEC = 5;
    private static final int NUM_BUCKETS = 3;

    public static final BiFunction<Integer, Integer, Integer> INTEGER_SUM =
            (integer, integer2) -> integer + integer2;

    public static final Function<Observable<Integer>, Observable<Integer>> WINDOW_SUM =
            window -> window.scan(0, INTEGER_SUM).skip(3);

    public static final Function<Observable<Integer>, Observable<Integer>> INNER_BUCKET_SUM =
            integerObservable -> {
                Single<Integer> integerSingle = integerObservable.reduce(new Integer(0), INTEGER_SUM);
                return new SingleToObservable(integerSingle);
            };


    public static void main(String[] args) throws InterruptedException {
        PublishSubject<Integer> publishSubject = PublishSubject.create();
        Subject<Integer> integerSubject = publishSubject.toSerialized();

        integerSubject
                .window(BUCKET_SIZE_IN_SEC, TimeUnit.SECONDS) // BUCKET_SIZE_IN_SEC秒作为一个基本块
                .flatMap(INNER_BUCKET_SUM)           // 基本块内数据求和
                .window(NUM_BUCKETS, 1)              // NUM_BUCKETS个块作为一个窗口，滚动步数为1
                .flatMap(WINDOW_SUM)                 // 窗口数据求和
                .subscribe((integer) -> {
                    if (integer >= THRESHOLD ) {
                        logger.info("[{}] call ...... {}, 超过警戒阀[{}]了！！", Thread.currentThread().getName(), integer, THRESHOLD);
                    } else {
                        logger.info("[{}] call ...... {}", Thread.currentThread().getName(), integer);
                    }});// 输出统计数据到日志

        // 缓慢发送数据，观察效果
        for (int i=0; i<30; ++i) {
            int nextInt = RandomUtils.nextInt(2, 6);
            logger.info("[{}] 产生随机数........【{}】  ", Thread.currentThread().getName(), nextInt);
            publishSubject.onNext(nextInt);
            Thread.sleep(1000);
        }
    }
}