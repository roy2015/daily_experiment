package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2019/9/9.
 *
 * 自除数 是指可以被它包含的每一位数除尽的数。

 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。

 还有，自除数不允许包含 0 。

 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/self-dividing-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 输入：
 上边界left = 1, 下边界right = 22
 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class TestSolution728 {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution728.class);

    /**
     * 执行用时 :3 ms, 在所有 java 提交中击败了86.97%的用户
     内存消耗 :33.8 MB, 在所有 java 提交中击败了75.43%的用户
     */
    static class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = left; i <= right; i++) {
                int  m=i,k;//m记录每次除以10， k记录余数
                boolean eligible = true;
                while (m != 0) {
                    k = m % 10;
                    if (k ==0) {//自除数不允许包含 0
                        eligible = false;
                        break;
                    } else {
                        if (i % k != 0) {
                            eligible = false;
                            break;
                        }
                    }
                    m = m / 10;
                }
                if (eligible) {
                    list.add(i);
                }
            }


            return list;
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = new Solution().selfDividingNumbers(1, 22);
        for (Integer integer : integers) {
            logger.info("{}", integer);
        }
    }
}
