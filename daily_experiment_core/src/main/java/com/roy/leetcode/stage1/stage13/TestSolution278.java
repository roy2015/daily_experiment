package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/3
 *
 *
 * 278. 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。
 *
 */
public class TestSolution278 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution278.class);


    public static class VersionControl {
        private int n;
        private int errorVersionStart;
        VersionControl(int n, int errorVersionStart) {
            this.n = n;
            this.errorVersionStart = errorVersionStart;
        }

        public boolean isBadVersion(int version) {
            if (version >= errorVersionStart) {
                return true;
            } else {
                return false;
            }
        }
    }


    public static class Solution extends VersionControl {
        Solution (int n, int errorVersionStart) {
            super(n, errorVersionStart);
        }

        /**
         *二分查找
         *  需要优化 17ms -> 16ms
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 17 ms, 在所有 Java 提交中击败了42.76%的用户
         * 内存消耗：
         * 36.5 MB, 在所有 Java 提交中击败了8.33%的用户
         *
         * @param n
         * @return
         */
        public int firstBadVersion(int n) {
            int low =0;
            int high = n-1;

            boolean oneIdxVal = isBadVersion(1);

            if (oneIdxVal) {
                return 1;
            }

            while(low <= high) {
                //两个int相加超界的问题解决方法两种，1.转long 2.用差值
                int mid ;
//              mid = (int) (((long)low + (long)high)/2);

                //完整版本
                /**
                 *
                 * int c;
                 *                 if((a^b)>0){                //判断a，b是同号
                 *                     if(a<=b){c=a+(b-a)/2;}  //判断a，b大小
                 *                     else {c=b+(a-b)/2;}
                 *                 }
                 *                 else {c=(a+b)/2;};
                 *
                 */
                mid=low + (high-low) /2;
                boolean midVal = isBadVersion(mid +1);
                if(midVal) {//true  error version
                    high = mid -1;
                } else {//false  correct version
                    low = mid +1;
                }
            }
            //not found
            return low +1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution(5,
                4).firstBadVersion(5));

        logger.info("{}", new Solution(2126753390,
                1702766719).firstBadVersion(2126753390));

    }
}
