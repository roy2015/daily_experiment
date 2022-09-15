package com.roy.miscellaneous.future;

import com.roy.miscellaneous.util.JacksonUtil;
import lombok.Data;
import lombok.experimental.Accessors;
import org.slf4j.LoggerFactory;
import org.springframework.util.concurrent.ListenableFutureAdapter;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.ListenableFutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestListenableFutureAdapter {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestListenableFutureAdapter.class);

    /**
     * 演示对象
     */
    @Data
    @Accessors(chain = true)
    class AdapteeDto {
        private String userId;
        private String userName;
        private int sleep;
    }

    /**
     * 返回对象对象
     */
    @Data
    @Accessors(chain = true)
    class AdaptDto {
        private String userId;
        private String message;
    }


    class Solution {
        public <T> ListenableFutureTask<T> getFutureTask(T dto) {
            Callable<T> task = () -> {
                int sleep = 3;
                logger.info("start sleeping {} second ....", sleep);
                TimeUnit.SECONDS.sleep(sleep);
//                int i = 1 / 0;
                logger.debug("callable exec ....");
                return dto;
            };

            ListenableFutureTask<T> listenableFuture = new ListenableFutureTask<>(task);
            return listenableFuture;
        }

        public  void test() {
            AdapteeDto adapteeDto = new TestListenableFutureAdapter().new AdapteeDto().setUserId("u-1").setUserName("jun");
            ListenableFutureTask<AdapteeDto> listenableFutureTask = getFutureTask(adapteeDto);

            ListenableFutureAdapter<AdaptDto, AdapteeDto> listenableFutureAdapter =
                    new ListenableFutureAdapter<AdaptDto, AdapteeDto>(listenableFutureTask) {
                        @Override
                        protected AdaptDto adapt(AdapteeDto adapteeResult) throws ExecutionException {
                            logger.info("adaptee future get {}", JacksonUtil.toJsonString(adapteeResult));
                            AdaptDto adaptDto = new AdaptDto().setUserId(adapteeResult.userId).setMessage("执行成功。");
                            return adaptDto;
                        }
                    };

            listenableFutureAdapter.addCallback(new ListenableFutureCallback<AdaptDto>() {
                @Override
                public void onFailure(Throwable e) {
                    logger.error(e.getMessage(), e);
                }

                @Override
                public void onSuccess(AdaptDto result) {
                    logger.info("onSuccess {}", JacksonUtil.toJsonString(result));
                }
            });

            listenableFutureTask.run();
        }

    }

    public static void main(String[] args) {
        new TestListenableFutureAdapter().new Solution().test();
    }
}
