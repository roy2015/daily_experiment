package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/11.
 *编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

  

 示例 1：

 输入：["h","e","l","l","o"]
 输出：["o","l","l","e","h"]
 示例 2：

 输入：["H","a","n","n","a","h"]
 输出：["h","a","n","n","a","H"]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution344 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution344.class);

    /**
     *
     * 算是二分交换吧
     *
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     内存消耗 :51.4 MB, 在所有 java 提交中击败了80.60%的用户
     *
     */
    static class Solution {
        public void reverseString(char[] s) {
            if (s == null || s.length == 0) {
                return;
            }

            int len = s.length;
            int mid = (len -1)/2;

            for (int i =mid; i >=0; i --) {
                char tmp;
                tmp = s[i];
                s[i] = s[len -1 - i];
                s[len -1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = {'h','e','l','l','o'};
        new Solution().reverseString(chars);
        logger.info("{}");
    }

}
