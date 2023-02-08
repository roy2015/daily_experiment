package com.roy.research.interview;

import cn.hutool.core.date.DateUtil;
import lombok.Data;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 *
 * 延迟队列demo
 * 描述： 往延迟队列里放需要随机延迟执行的task， consumer自旋消费
 * 使用场景： 未支付订单的半小时取消
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolutionDelayQueue {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionDelayQueue.class);


    static class Solution {
        private DelayQueue<DelayedTask> delayedTaskDelayQueue;


        public void testDelayQueue() throws InterruptedException, IOException {
            delayedTaskDelayQueue = new DelayQueue<>();
            int n = 3;
            DelayedTask[] delayedTasks = new DelayedTask[n];
            for (int i = 0; i < n; i++) {
                Random random = new Random();
                int randomExpireTimeSecond = random.nextInt(10) + 1;
                delayedTasks[i] = new DelayedTask("t" + i, randomExpireTimeSecond, new Date());
                delayedTaskDelayQueue.add(delayedTasks[i]);
                TimeUnit.SECONDS.sleep(3);
            }

            new Thread(new DelayedQueueConsumer()).start();
            System.in.read();
        }

        @Data
        public class DelayedTask implements Delayed {
            private Date createTime;//创建时间
            private String taskName;
            private long expireTime;//失效的具体时间
            private int toExpireTimeSecond;//几秒后失效

            public DelayedTask(String taskName, int toExpireTimeSecond, Date createTime) {
                this.createTime = createTime;
                this.taskName = taskName;
                this.toExpireTimeSecond = toExpireTimeSecond;
                this.expireTime = createTime.getTime() +
                        TimeUnit.MILLISECONDS.convert(toExpireTimeSecond, TimeUnit.SECONDS);
            }

            @Override
            public int compareTo(Delayed o) {
                return (int) (expireTime - ((DelayedTask)o).getExpireTime());
            }

            @Override
            public long getDelay(TimeUnit unit) {
                long elapseTime = expireTime - System.currentTimeMillis();
                return unit.convert(elapseTime, TimeUnit.MILLISECONDS);
            }
        }

        public class DelayedQueueConsumer implements Runnable {

            @Override
            public void run() {
                for (;;) {
                    try {
                        DelayedTask task = delayedTaskDelayQueue.take();
                        logger.info("任务 [{}], [创建时间：{}], 延迟间隔: [{}] , 延迟时间: [{}]",
                                task.getTaskName(),
                                DateUtil.format(task.getCreateTime(),"yyyy-MM-dd HH:mm:ss" ),
                                task.getToExpireTimeSecond(),
                                DateUtil.format(new Date(task.getExpireTime()),"yyyy-MM-dd HH:mm:ss" ));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Solution().testDelayQueue();
    }
}
