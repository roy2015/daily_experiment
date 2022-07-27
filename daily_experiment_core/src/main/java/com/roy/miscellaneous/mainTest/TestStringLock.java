package com.roy.miscellaneous.mainTest;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Interner;
import com.google.common.collect.Interners;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试google guava的Interner, 用作string lock
 *
 * @author guojun
 * @date 2022/7/27 11:37
 */
@Slf4j
public class TestStringLock {


  static class Solution {
    private Interner<String> stringPool = Interners.newWeakInterner();
    private CountDownLatch countDownLatch = new CountDownLatch(6);

    public void test() throws InterruptedException {


      new Thread(new Task("1-1", "1")).start();
      new Thread(new Task( "1-2", "1")).start();
      new Thread(new Task( "1-3", "1")).start();

      new Thread(new Task( "2-1", "2")).start();
      new Thread(new Task( "2-2", "2")).start();
      new Thread(new Task( "2-3", "2")).start();
      log.info("{}", LocalDateTime.now());
      countDownLatch.await();

    }

    @AllArgsConstructor
    private class Task implements Runnable {
      private String taskId;
      private String outputStr ;

      @Override
      public void run() {
        synchronized (stringPool.intern(outputStr)) {
          try {
            TimeUnit.SECONDS.sleep(3);
            log.debug("trhead[{}], output[{}]", taskId, outputStr);
          } catch (InterruptedException e) {
            log.error(e.getMessage(),e);
          }
          countDownLatch.countDown();
        }
      }
    }


  }

  public static void main(String[] args) throws Exception {
    new Solution().test();

  }
}
