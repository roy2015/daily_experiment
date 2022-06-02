package com.roy.miscellaneous.mainTest;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


import lombok.extern.slf4j.Slf4j;

/**
 * @author guojun
 * @date 2021/6/11
 */
@Slf4j
public class TestCompleteFuture {
//    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestCompleteFuture.class);


    static class Solution {
        public Future<String> calculateAsync() throws InterruptedException {
            CompletableFuture<String> completableFuture = new CompletableFuture<>();

            Executors.newCachedThreadPool().submit(() -> {
                Thread.sleep(500);
                completableFuture.complete("Hello");
                return null;
            });

            return completableFuture;
        }

        public String test() throws InterruptedException, ExecutionException {
            Future<String> completableFuture = calculateAsync();
            String result = completableFuture.get();
            log.info("{}", result);
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        log.info("=============");
        new Solution().test();
    }
}
