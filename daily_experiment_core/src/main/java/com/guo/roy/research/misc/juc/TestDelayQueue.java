package com.guo.roy.research.misc.juc;

import cn.hutool.core.date.DateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author guojun
 * @date 2021/6/11
 */
@Slf4j
public class TestDelayQueue {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestDelayQueue.class);

    @Data
    static class DelayTask implements Delayed {
        private String taskName;
        private Date scheduleTime;

        public DelayTask(String taskName, Date scheduleTime) {
            this.taskName = taskName;
            this.scheduleTime = scheduleTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return scheduleTime.getTime() - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.SECONDS) - o.getDelay(TimeUnit.SECONDS) > 0) {
                return 1;
            } else if (this.getDelay(TimeUnit.SECONDS) - o.getDelay(TimeUnit.SECONDS) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    static class Solution {

        public void main() throws InterruptedException {
            DelayQueue<DelayTask> delayQueue = new DelayQueue<DelayTask>();
            Date now = new Date();
            DelayTask task1 = new DelayTask("task1", DateUtil.offsetSecond(now , 1));
            DelayTask task5 = new DelayTask("task5", DateUtil.offsetSecond(now , 10));
            DelayTask task2 = new DelayTask("task2", DateUtil.offsetSecond(now , 3));
            DelayTask task4 = new DelayTask("task4", DateUtil.offsetSecond(now , 7));
            DelayTask task3 = new DelayTask("task3", DateUtil.offsetSecond(now , 5));

            delayQueue.add(task1);
            delayQueue.add(task5);
            delayQueue.add(task2);
            delayQueue.add(task4);
            delayQueue.add(task3);

            log.info("now: {}", new Date());
            while (!delayQueue.isEmpty()) {
                DelayTask task = delayQueue.take();
                log.info("taskName: {} 计划时间:{} 实际时间:{}", task.getTaskName(), task.getScheduleTime(), new Date());

            }

        }

    }

    public static void main(String[] args) throws Exception {
        new Solution().main();
//        TimeUnit.SECONDS.sleep(10);
    }
}
