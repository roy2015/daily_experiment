package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/22.
 *排排坐，分糖果。

 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。

 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。

 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。

 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。

 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。

  

 示例 1：

 输入：candies = 7, num_people = 4
 输出：[1,2,3,1]
 解释：
 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 示例 2：

 输入：candies = 10, num_people = 3
 输出：[5,2,3]
 解释：
 第一次，ans[0] += 1，数组变为 [1,0,0]。
 第二次，ans[1] += 2，数组变为 [1,2,0]。
 第三次，ans[2] += 3，数组变为 [1,2,3]。
 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
  

 提示：

 1 <= candies <= 10^9
 1 <= num_people <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/distribute-candies-to-people
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution1103 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1103.class);

    /**
     *
     * 执行用时 :1 ms, 在所有 java 提交中击败了96.95%的用户
     * 内存消耗 :33.8 MB, 在所有 java 提交中击败了100.00%的用户
     */
    static class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int[] ret = new int[num_people];
            int k =1;
            if (candies ==0 || num_people ==0) {
                return ret;
            }
            while (true) {
                for(int i =0; i<num_people; i++, k++) {
                    if (candies > k) {
                        ret[i] +=k;
                        candies -=k;
                    } else {
                        ret[i] += candies;
//                        candies =0;
                        return ret;
                    }
                }
            }
        }

        /**
         * 执行用时 :1 ms, 在所有 java 提交中击败了96.95%的用户
         * 内存消耗 :34 MB, 在所有 java 提交中击败了100.00%的用户
         * @param candies
         * @param num_people
         * @return
         */
        public int[] distributeCandies1(int candies, int num_people) {
            int[] ret = new int[num_people];
            if (candies ==0 || num_people ==0) {
                return ret;
            }
            for (int i = 1; true ; i++) {
                if (candies  <= i) {
                    ret[i % num_people ==0 ? num_people -1 : i % num_people -1 ] += candies;
                    return ret;
                } else {
                    ret[i % num_people ==0 ? num_people -1 : i % num_people -1 ] += i;
                    candies -= i;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new Solution().distributeCandies1(7, 4);
        logger.info("{}");
    }

}
