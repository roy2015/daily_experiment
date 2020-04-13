package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/12 20:13
 *
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。

所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。

 

示例 1：

输入：address = "1.1.1.1"
输出："1[.]1[.]1[.]1"
示例 2：

输入：address = "255.100.50.0"
输出："255[.]100[.]50[.]0"
 

提示：

给出的 address 是一个有效的 IPv4 地址

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/defanging-an-ip-address
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution1108 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1108.class);


    static class Solution {
        /**
         *
         * 直接用函数replaceAll
         *
         * 执行结果：通过显示详情
         * 执行用时 :
         * 3 ms, 在所有 Java 提交中击败了28.66%的用户
         * 内存消耗 :
         * 38 MB, 在所有 Java 提交中击败了5.19%的用户
         * @param address
         * @return
         */
        public String defangIPaddr(String address) {
            return address.replaceAll("\\.","[.]");
        }

        /**
         *
         * 手写循环
         *
         * 执行用时 :
         0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :
         37.5 MB, 在所有 Java 提交中击败了5.19%的用户
         * @param address
         * @return
         */
        public String defangIPaddr_1(String address) {
            char[] chars = address.toCharArray();
            StringBuffer sb = new StringBuffer();

            for (char ch : chars) {
                if ('.' == ch) {
                    sb.append("[.]");
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
//        logger.info(new Solution().defangIPaddr("1.1.1.1"));
        logger.info(new Solution().defangIPaddr_1("1.1.1.1"));
    }
}
