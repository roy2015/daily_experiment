package com.roy.leetcode.stage1.stage10;

import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/22.
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
  示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-integer
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution7 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution7.class);

    /**
     *
     * 执行用时 :4 ms, 在所有 java 提交中击败了42.23%的用户
     内存消耗 :34.1 MB, 在所有 java 提交中击败了78.46%的用户
     *
     */
    static class Solution {
        /**
         *
         * 变成字符数组后反序拼接
         *
         * 执行用时 :4 ms, 在所有 java 提交中击败了42.23%的用户
         内存消耗 :34.1 MB, 在所有 java 提交中击败了78.46%的用户
         *
         * @param x
         * @return
         */
        public int reverse(int x) {
            boolean isNagtive = false;
            int candidateX = 0;
            try {
                if (x < 0) {
                    isNagtive = true;
                    candidateX = -x;
                } else {
                    candidateX =x;
                }

                String s = candidateX + "";
                StringBuffer reverseSB = new StringBuffer();
                char[] toCharArray = s.toCharArray();
                for (int i = toCharArray.length - 1; i >= 0; i--) {
                    reverseSB.append(toCharArray[i]);
                }
                int retInt = Integer.parseInt(reverseSB.toString());
                return isNagtive ? -retInt : retInt ;
            } catch (Exception e) {
                return 0;
            }
        }

        /**
         * 二分交换字符数组
         *
         * 执行用时 :3 ms, 在所有 java 提交中击败了67.84%的用户
         内存消耗 :33.8 MB, 在所有 java 提交中击败了79.22%的用户
         * @param x
         * @return
         */
        public int reverse1(int x) {
            boolean isNagtive = false;
            int candidateX = 0;
            try {
                if (x < 0) {
                    isNagtive = true;
                    candidateX = -x;
                } else {
                    candidateX =x;
                }

                String s = Integer.valueOf(candidateX).toString();
                char[] toCharArray = s.toCharArray();
                for (int i = 0; i <= (toCharArray.length -1) / 2; i++) {
                    char tmp = toCharArray[i];
                    toCharArray[i] = toCharArray[toCharArray.length -1 - i];
                    toCharArray[toCharArray.length -1 - i] = tmp;
                }
                int retInt = Integer.parseInt(new String(toCharArray));
                return isNagtive ? -retInt : retInt ;

            } catch (Exception e) {
                return 0;
            }
        }

        /**
         * 只有一次转字符串数组
         *
         * 执行用时 :3 ms, 在所有 java 提交中击败了67.84%的用户
         内存消耗 :33.6 MB, 在所有 java 提交中击败了79.94%的用户
         * @param x
         * @return
         */
        public int reverse2(int x) {
            boolean isNagtive = false;
            int candidateX = 0;
            try {
                if (x < 0) {
                    isNagtive = true;
                    candidateX = -x;
                } else {
                    candidateX =x;
                }

                String s = Integer.valueOf(candidateX).toString();
                long k = 1;
                long sum =0;
                char[] toCharArray = s.toCharArray();
                for (int i = 0; i < toCharArray.length; i++) {
                    sum += (toCharArray[i] - '0') * k;
                    k = k * 10;
                }
                return isNagtive ? -sum < Integer.MIN_VALUE ? 0 : (int)-sum  : sum > Integer.MAX_VALUE ? 0 : (int) sum ;
            } catch (Exception e) {
                return 0;
            }
        }

        /**
         *
         * 分离到int[]，再反序输出，没走字符数组
         * 执行用时 :2 ms, 在所有 java 提交中击败了81.34%的用户
         内存消耗 :33.6 MB, 在所有 java 提交中击败了80.34%的用户
         * @param x
         * @return
         */
        public int reverse3(int x) {
            boolean isNagtive = false;
            int candidateX = 0;
            try {
                if (x < 0) {
                    isNagtive = true;
                    candidateX = -x;
                    if (candidateX < 0) {
                        throw new Exception();
                    }
                } else {
                    candidateX = x;
                }

                int[] ints = new int[10];
                int m =0;
                long k ;
                do {
                    ints[m++] = candidateX % 10;
                    candidateX = candidateX / 10;
                } while (candidateX != 0);

                long sum =0;
                k = 1;
                for (int i = m-1; i >= 0; i--) {
                    sum += ints[i] * k;
                    k = k * 10;
                }
                return isNagtive ? -sum < Integer.MIN_VALUE ? 0 : (int)-sum  : sum > Integer.MAX_VALUE ? 0 : (int) sum ;
            } catch (Exception e) {
                return 0;
            }
        }

        /**
         * 还是用了 s.length()，不过没用char[]
         *
         * 执行用时 :2 ms, 在所有 java 提交中击败了81.34%的用户
         内存消耗 :33.5 MB, 在所有 java 提交中击败了80.84%的用户
         * @param x
         * @return
         */
        public int reverse4(int x) {
            boolean isNagtive = false;
            int candidateX = 0;
            try {
                if (x < 0) {
                    isNagtive = true;
                    candidateX = -x;
                    if (candidateX < 0) {
                        throw new Exception();
                    }
                } else {
                    candidateX = x;
                }

                String s = Integer.valueOf(candidateX).toString();
                int len = s.length();
                long k = (long) Math.pow(10, len - 1);

                int m =0;
                long sum =0;
                do {
                    sum += candidateX % 10 * k;
                    k = k / 10;
                    candidateX = candidateX / 10;
                } while (candidateX != 0);


                return isNagtive ? -sum < Integer.MIN_VALUE ? 0 : (int)-sum  : sum > Integer.MAX_VALUE ? 0 : (int) sum ;
            } catch (Exception e) {
                return 0;
            }
        }

        /**
         * 执行用时 :2 ms, 在所有 java 提交中击败了81.34%的用户
         内存消耗 :33.8 MB, 在所有 java 提交中击败了79.10%的用户
         * @param x
         * @return
         */
        public int reverse6(int x) {
            boolean isNagtive = false;
            int candidateX = 0;
            try {
                if (x < 0) {
                    isNagtive = true;
                    candidateX = -x;
                    if (candidateX < 0) {
                        throw new Exception();
                    }
                } else {
                    candidateX = x;
                }

                long k = 10l;
                while (k < candidateX ) {
                    k = k * 10;
                }

                if (k != candidateX) {
                    k = k  /10;
                }
                long sum =0;
                do {
                    sum += candidateX % 10 * k;
                    k = k / 10;
                    candidateX = candidateX / 10;
                } while (candidateX != 0);


                return isNagtive ? -sum < Integer.MIN_VALUE ? 0 : (int)-sum  : sum > Integer.MAX_VALUE ? 0 : (int) sum ;
            } catch (Exception e) {
                return 0;
            }
        }

        /**
         * 用了stack就变成4ms了？？
         *
         * 执行用时 :4 ms, 在所有 java 提交中击败了42.23%的用户
         内存消耗 :34 MB, 在所有 java 提交中击败了78.65%的用户
         * @param x
         * @return
         */
        public int reverse5(int x) {
            boolean isNagtive = false;
            int candidateX = 0;
            try {
                if (x < 0) {
                    isNagtive = true;
                    candidateX = -x;
                    if (candidateX < 0) {
                        throw new Exception();
                    }
                } else {
                    candidateX = x;
                }

                int k =0;
                Stack<Integer> stack = new Stack();
                do {
                    stack.push(candidateX % 10);
                    k = k / 10;
                    candidateX = candidateX / 10;
                } while (candidateX != 0);

                long radio = 1;
                long sum =0;
                while (!stack.isEmpty()) {
                    sum += stack.pop() * radio;
                    radio = radio * 10;
                }
                return isNagtive ? -sum < Integer.MIN_VALUE ? 0 : (int)-sum  : sum > Integer.MAX_VALUE ? 0 : (int) sum ;
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().reverse6 (-100));
    }

}
