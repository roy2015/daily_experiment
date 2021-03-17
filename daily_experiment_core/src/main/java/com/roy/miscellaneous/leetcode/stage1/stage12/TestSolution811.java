package com.roy.miscellaneous.leetcode.stage1.stage12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/28
 *
 * 811. 子域名访问计数
一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。

给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。

接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。

示例 1:
输入:
["9001 discuss.leetcode.com"]
输出:
["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
说明:
例子中仅包含一个网站域名："discuss.leetcode.com"。按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被访问了9001次。
示例 2
输入:
["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
输出:
["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
说明:
按照假设，会访问"google.mail.com" 900次，"yahoo.com" 50次，"intel.mail.com" 1次，"wiki.org" 5次。
而对于父域名，会访问"mail.com" 900+1 = 901次，"com" 900 + 50 + 1 = 951次，和 "org" 5 次。
注意事项：

cpdomains 的长度小于 100。
每个域名的长度小于100。
每个域名地址包含一个或两个"."符号。
输入中任意一个域名的访问次数都小于10000。

 */
public class TestSolution811 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution811.class);


    static class Solution {
        /**
         *
         *
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时 :21 ms, 在所有 Java 提交中击败了82.58%的用户
         * 内存消耗 :40.7 MB, 在所有 Java 提交中击败了33.33%的用户
         *
         * @param cpdomains
         * @return
         */
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> retMap = new HashMap<>();
            ArrayList<String> retList = new ArrayList<>();

            for (String cpdomain : cpdomains) {
                resolvedSingleStr(cpdomain, retMap);
            }

            for (Map.Entry<String, Integer> entry : retMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                retList.add(value + " " + key);
            }
            return retList;
        }

        private void resolvedSingleStr (String cpdomain, Map<String, Integer> retMap) {
            int blankIdx = cpdomain.indexOf(" ");
            int len = cpdomain.length();
            int times = Integer.parseInt(cpdomain.substring(0, blankIdx));

            //解析出域名
            int start = blankIdx + 1;

            char[] chars = cpdomain.toCharArray();
            retMap.compute(new String(chars, start, len - start), (s, old) -> {
                if (null == old) {
                    return new Integer(times);
                } else {
                    int newVal = old.intValue() + times;
                    return newVal;
                }
            });

            while (start < len) {
                int i = start;
                for (; i < len; i++) {
                    if (chars[i] == '.') {
                        break;
                    }
                }

                if (i < len) {
                    start = i +1;
                    retMap.compute(new String(chars, start, len - start), (s, old) -> {
                        if (null == old) {
                            return new Integer(times);
                        } else {
                            int newVal = old.intValue() + times;
                            return newVal;
                        }
                    });
                } else {//没有"."，直接返回计算下一个字符串
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().subdomainVisits(new String[]{
                "9001 discuss.leetcode.com"
        }));//"9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"

        logger.info("{}", new Solution().subdomainVisits(new String[]{
                "900 google.mail.com",
                "50 yahoo.com",
                "1 intel.mail.com",
                "5 wiki.org"
        }));//"901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"
    }
}
