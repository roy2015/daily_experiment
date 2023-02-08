package com.roy.research.interview;

/**
 * @author guojun
 * @date 2021/8/4 下午2:28
 */
public class MyTest {

    public static void main(String[] args) {
        int[] data = {1,20,1,1,20};
        int result = 0;


        int stealCnt = data[0];
        int nonStealCnt = 0;

        int length = data.length;
        if (length == 1) {
            result = data[0];
            System.out.println(result);
            return;
        }

        for (int i = 1; i < length; i++) {
            int currNonstealCnt1 = stealCnt;
            int currNonstealCnt2 = nonStealCnt;

            int currstealCnt = nonStealCnt + data[i];

            nonStealCnt = Math.max(currNonstealCnt1, currNonstealCnt2);
            stealCnt = currstealCnt;

        }
        System.out.println(Math.max(stealCnt, nonStealCnt));


    }
}
