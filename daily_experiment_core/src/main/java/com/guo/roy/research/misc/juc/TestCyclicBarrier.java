package com.guo.roy.research.misc.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import org.slf4j.LoggerFactory;

/**
 *
 * 赛马程序 ，七匹马（步幅频率相同）， 每次步幅随机1m，2m，3m,  先到达75m获胜
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestCyclicBarrier {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestCyclicBarrier.class);


    static class Horse implements Runnable {
        private static int counter = 0;
        private final int id = counter++;
        private int strides = 0;//步幅累计
        private static Random rand = new Random(47);
        private static CyclicBarrier barrier;
        public Horse(CyclicBarrier b) { barrier = b; }
        public synchronized int getStrides() { return strides; }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    synchronized(this) {
                        strides += rand.nextInt(3); // Produces 0, 1 or 2
                    }
                    barrier.await();
                }
            } catch(InterruptedException e) {
                // A legitimate way to exit
            } catch(BrokenBarrierException e) {
                // This one we want to know about
                throw new RuntimeException(e);
            }
        }
        public String toString() { return "Horse " + id + " "; }
        public String tracks() {
            StringBuilder s = new StringBuilder();
            for(int i = 0; i < getStrides(); i++)
                s.append("*");
            s.append(id);
            return s.toString();
        }
    }

    static class HorseRace {
        static final int FINISH_LINE = 75;
        private List<Horse> horses = new ArrayList<Horse>();
        private ExecutorService exec =
                Executors.newCachedThreadPool();
        private CyclicBarrier barrier;
        public HorseRace(int nHorses, final int pause) {
            //CyclicBarrier第二个参数 barrierAction
            barrier = new CyclicBarrier(nHorses, new Runnable() {
                public void run() {
                    StringBuilder s = new StringBuilder();
                    //画栅栏
                    for(int i = 0; i < FINISH_LINE; i++)
                        s.append("="); // The fence on the racetrack
                    logger.info("{}",s);

                    //画每一匹马轨迹
                    for(Horse horse : horses)
                        logger.info("{}", horse.tracks());

                    //判断是否有马胜出
                    for(Horse horse : horses)
                        if(horse.getStrides() >= FINISH_LINE) {
                            logger.info("{}", (horse + "won!"));
                            exec.shutdownNow();
                            return;
                        }
                    try {
                        //sleep
                        TimeUnit.MILLISECONDS.sleep(pause);
                    } catch(InterruptedException e) {
                        logger.info("{}", "barrier-action sleep interrupted");
                    }
                }
            });
            for(int i = 0; i < nHorses; i++) {
                Horse horse = new Horse(barrier);
                horses.add(horse);
                exec.execute(horse);
            }
        }
        public static void main(String[] args) {
            int nHorses = 7;
            int pause = 100;
            if(args.length > 0) { // Optional argument
                int n = new Integer(args[0]);
                nHorses = n > 0 ? n : nHorses;
            }
            if(args.length > 1) { // Optional argument
                int p = new Integer(args[1]);
                pause = p > -1 ? p : pause;
            }
            new HorseRace(nHorses, pause);
        }
    } /* (Execute to see output) *///:~
}
