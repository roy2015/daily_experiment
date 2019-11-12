package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/22.
 *给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。 

 如果没有两个连续的 1，返回 0 。

  

 示例 1：

 输入：22
 输出：2
 解释：
 22 的二进制是 0b10110 。
 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
 第一对连续的 1 中，两个 1 之间的距离为 2 。
 第二对连续的 1 中，两个 1 之间的距离为 1 。
 答案取两个距离之中最大的，也就是 2 。
 示例 2：

 输入：5
 输出：2
 解释：
 5 的二进制是 0b101 。
 示例 3：

 输入：6
 输出：1
 解释：
 6 的二进制是 0b110 。
 示例 4：

 输入：8
 输出：0
 解释：
 8 的二进制是 0b1000 。
 在 8 的二进制表示中没有连续的 1，所以返回 0 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-gap
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution868 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution868.class);

    /**
     *
     *
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     *  内存消耗 :33.4 MB, 在所有 java 提交中击败了70.16%的用户
     * 思路： 最高位肯定为1 ， 再用两个高低指针就可以了
     */
    static class Solution {
        public int binaryGap(int N) {
            int low=0, hight=0;
            int ret =0;
            int index =0;
            boolean flag = false;

            if (N ==0 || N ==1) {
                return 0;
            }

            while (N != 0) {
                index ++;
                if((N & 1) != 0 ){
                    hight = index;
                    if (!flag) {
                        low = index;
                        flag =true;
                    } else {
                        if (hight - low > ret) {
                            ret = hight - low;
                        }
                        low = hight;
                    }
                }
                N = N >>1;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().binaryGap(22));
    }

}
