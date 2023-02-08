package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/8
 *
 *
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 *
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，
 * 你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 *
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 *
 * 示例：
 *
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 * 提示：
 *
 * len(solution) = len(guess) = 4
 * solution和guess仅包含"R","G","B","Y"这4种字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/master-mind-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class TestSolutionInterview1615 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview1615.class);

    static class Solution {
        /**
         *这个题目不好理解，只有不断的testCase才弄清楚细节
         * 可以实现0ms，但还是写个通用的吧，要不然很多变量和swithc不可扩展
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了46.89%的用户
         * 内存消耗：
         * 37.7 MB, 在所有 Java 提交中击败了48.21%的用户
         *
         * @param solution
         * @param guess
         * @return
         */
        public int[] masterMind(String solution, String guess) {
            //做一个通用的
            Map<Integer, Integer> idxDic = new HashMap<>();
            idxDic.put(Integer.valueOf('R'), 0);
            idxDic.put(Integer.valueOf('G'), 1);
            idxDic.put(Integer.valueOf('B'), 2);
            idxDic.put(Integer.valueOf('Y'), 3);

            int size = idxDic.size();
            //RGBY出现的次数
            int[] cntArrays = new int[size];
            //RGBY是否出现  -1未出现
            int[] idxArrays = new int[size];
            Arrays.fill(idxArrays, -1);

            char[] solutionChars = solution.toCharArray();
            char[] guessChars = guess.toCharArray();

            for (int i = 0; i < solutionChars.length; i++) {
                int solutionCharInt = solutionChars[i];
                Integer idx = idxDic.get(solutionCharInt);
                idxArrays[idx] =  i;
                cntArrays[idx] ++;
            }

            int guessCnt = 0;
            int likeGuessCnt = 0;
            //1. 计算猜中的数目
            for (int i = 0; i < solutionChars.length; i++) {
                int solutionChar = solutionChars[i];
                int guessChar = guessChars[i];
                if ( guessChar == solutionChar) {
                    guessCnt ++;
                    Integer idx = idxDic.get(solutionChar);
                    cntArrays[idx] --;
                }
            }

            //2. 计算伪猜中的数目
            for (int i = 0; i < solutionChars.length; i++) {
                int solutionChar = solutionChars[i];
                int guessChar = guessChars[i];

                if(guessChar != solutionChar) {
                    Integer idx = idxDic.get(guessChar);
                    if (idxArrays[idx] != -1 && cntArrays[idx] > 0 ) {
                        likeGuessCnt ++;
                        cntArrays[idx] --;
                    }
                }
            }
            return new int[]{guessCnt, likeGuessCnt};
        }


    }

    public static void main(String[] args) {
        logger.info("{}",new Solution().masterMind("GGBB", "RBYB"));//1,1
        logger.info("{}",new Solution().masterMind("YBBY", "GYYB"));//0,3
        logger.info("{}",new Solution().masterMind("RGBY", "GGRR"));//1,1
        logger.info("{}",new Solution().masterMind("RRRR", "RBBB"));//1,0
        logger.info("{}",new Solution().masterMind("RBRR", "RBBR"));//3,0
    }
}
