package com.guo.roy.research.misc.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;
import org.springframework.util.concurrent.ListenableFutureTask;

import com.guo.roy.research.misc.util.JacksonUtil;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试spring的可监听的FutureTask
 *
 *
 *
 * @author guojun
 * @date 2021/6/11
 */
@Slf4j
public class TestListenableFutureTask {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestListenableFutureTask.class);

    /**
     * 演示对象
     */
    @Data
    @Accessors(chain = true)
    class DemoDto {
        private String userId;
        private String userName;
    }

    class Solution {
        public <T> ListenableFutureTask<T> getFutureTask(T dto) {
            Callable<T> task = () -> {
                int sleep = 5;
                logger.info("start sleeping {} second ....", sleep);
                TimeUnit.SECONDS.sleep(sleep);
//                int i = 1 / 0;
                logger.debug(JacksonUtil.toJsonString(dto));
                return dto;
            };

            ListenableFutureTask<T> listenableFuture = new ListenableFutureTask<>(task);
            return listenableFuture;
        }

        public void testMain() {
            DemoDto demoDto = new DemoDto().setUserId("guo").setUserName("jun");
            ListenableFutureTask<DemoDto> listenableFutureTask = getFutureTask(demoDto);
            listenableFutureTask.addCallback(result -> {
                logger.info("成功执行，执行回调，数据[{}]", JacksonUtil.toJsonString(result));
            }, e -> {
                logger.error("发生错误了。。。。。。。。");
                logger.error(e.getMessage(), e);
            });
            listenableFutureTask.run();
        }
    }



    public static void main(String[] args) {
        logger.info("main start");
        TestListenableFutureTask completeAbleFuture = new TestListenableFutureTask();
        Solution solution = completeAbleFuture.new Solution();
        new Thread(() -> solution.testMain()).start();
        logger.info("main continue..");
    }
}
