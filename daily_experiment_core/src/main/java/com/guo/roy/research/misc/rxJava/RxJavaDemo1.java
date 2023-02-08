package com.guo.roy.research.misc.rxJava;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by apple on 2019/8/22.
 *
 * RxJava2.0的基本使用
 *
 *
 *  Observable  Observer
 */
public class RxJavaDemo1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(RxJavaDemo1.class);

    public static void test1() {
        Observable<String> publish = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("one");
                emitter.onNext("two");
                emitter.onComplete();
            }
        });

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                LOGGER.info("onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                LOGGER.info("onNext: {}", s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LOGGER.info(e.getMessage(), e);
            }

            @Override
            public void onComplete() {
                LOGGER.info("onComplete:");
            }
        };

        publish.subscribe(observer);
    }

    public static void test2() {
        PublishSubject<String> publishSubject = PublishSubject.create();

        publishSubject.onNext("1");
        publishSubject.onNext("2");
        publishSubject.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {// Disposable: 一次性的
                LOGGER.info("onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull String s) {
                LOGGER.info("onNext: {}", s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LOGGER.info("onError: {}", e.getMessage());
            }

            @Override
            public void onComplete() {
                LOGGER.info("onComplete: ");
            }
        });

        publishSubject.onNext("3");
        publishSubject.onNext("4");
        publishSubject.onComplete();
    }

    public static void test3() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("123");
                emitter.onNext("456");
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe( data -> {
                    LOGGER.info(data);
                });
    }


    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
        test3();
        TimeUnit.SECONDS.sleep(10);
    }
}
