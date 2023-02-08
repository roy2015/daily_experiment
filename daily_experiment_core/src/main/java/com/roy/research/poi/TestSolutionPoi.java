package com.roy.research.poi;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolutionPoi {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionPoi.class);


    static class Solution {
        /**
         * 计算两个单元格之间的单元格数目(同一行)
         */
        public int countNullCell(String refA, String refB) {
            String xfdA = refA.replaceAll("\\d+", "");
            String xfdB = refB.replaceAll("\\d+", "");

            xfdA = fillChar(xfdA, 3, '@', true);
            xfdB = fillChar(xfdB, 3, '@', true);

            char[] letterA = xfdA.toCharArray();
            char[] letterB = xfdB.toCharArray();
            int res = (letterA[0] - letterB[0]) * 26 * 26 + (letterA[1] - letterB[1]) * 26 + (letterA[2] - letterB[2]);
            return res - 1;
        }

        private String fillChar(String str, int len, char let, boolean isPre) {
            int lenA = str.length();
            if (lenA < len) {
                if (isPre) {
                    StringBuilder strBuilder = new StringBuilder(str);
                    for (int i = 0; i < (len - lenA); i++) {
                        strBuilder.insert(0, let);
                    }
                    str = strBuilder.toString();
                } else {
                    StringBuilder strBuilder = new StringBuilder(str);
                    for (int i = 0; i < (len - lenA); i++) {
                        strBuilder.append(let);
                    }
                    str = strBuilder.toString();
                }
            }
            return str;
        }

        public int test(String currentCellLocation) {
            String xfdA = currentCellLocation.replaceAll("\\d+", "");
            xfdA = fillChar(xfdA, 3, '@', true);
            char[] letterA = xfdA.toCharArray();
            char[] letterB = {'@','@','A'};
            return   (letterA[0] - letterB[0]) * 26 * 26 + (letterA[1] - letterB[1]) * 26 + (letterA[2] - letterB[2]);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.test("B2"));
//        System.out.println(solution.countNullCell("B2","@"));
//        System.out.println(solution.fillChar("A1", 3, '@', true));
//        System.out.println(solution.fillChar("BG185", 3, '@', true));


    }
}
