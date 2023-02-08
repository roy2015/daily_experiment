package com.guo.roy.research.leetcode.stage2.stage20;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 *
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 * 示例 1:
 *
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 *
 * 提示：
 *
 * 1 <= num <= 3999
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author guojun
 * @date 2021/11/11
 */
public class TestSolution12 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution12.class);


    static class Solution {
        private static Map<Integer, String> dicMap = new HashMap<>();
        private int[] slots = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500 , 900, 1000};
        private int slotsLen = slots.length;
        private int max = 1000;
        private String thousand = "M";
        static {
            dicMap.put(1, "I");
            dicMap.put(5, "V");
            dicMap.put(10, "X");
            dicMap.put(50, "L");
            dicMap.put(100, "C");
            dicMap.put(500, "D");
            dicMap.put(1000, "M");
            dicMap.put(4, "IV");
            dicMap.put(9, "IX");
            dicMap.put(40, "XL");
            dicMap.put(90, "XC");
            dicMap.put(400, "CD");
            dicMap.put(900, "CM");
        }

        /**
         *
         * 1. 处理大于1000的部分
         * 2. 处理小于1000的部分
         * 3. 1,2两部都要使用一个公用方法
         *
         * 执行结果：通过
         * 执行用时：3 ms, 在所有 Java 提交中击败了99.83%的用户
         * 内存消耗：37.8 MB, 在所有 Java 提交中击败了75.05%的用户
         * 通过测试用例：
         * 3999 / 3999
         *
         */
        public String intToRoman(int num) {
            if (num <= max) {
                return processRoman(num);
            }
            StringBuilder retSb = new StringBuilder();
            int thousandTimes = num / max;
            for (int i = 0; i < thousandTimes; i++) {
                retSb.append(thousand);
            }
            return retSb.append(processRoman(num % max)).toString();
        }

        /**
         * 通用方法，处理1000以下阿拉伯数字转罗马数字
         * 插槽匹配的思路，每次计算后基数变小，减少循环次数~~
         * @param num
         * @return
         */
        public String processRoman(int num) {
            StringBuilder sb = new StringBuilder();
            int startIdx = slotsLen -1;
            while (num > 0) {
                int i = startIdx;
                while (true) {
                    if (num >= slots[i]) {
                        break;
                    }
                    i --;
                }
                sb.append(dicMap.get(slots[i]));
                num -= slots[i];
                startIdx = i;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().intToRoman(58));//LVIII
        logger.info("{}", new Solution().intToRoman(4));//IV
        logger.info("{}", new Solution().intToRoman(9));//IX
        logger.info("{}", new Solution().intToRoman(1994));//MCMXCIV
        logger.info("{}", new Solution().intToRoman(3999));//"MMMCMXCIX"
    }
}
