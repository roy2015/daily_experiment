package com.guo.roy.research.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 *
 * 838. 推多米诺
 * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 *
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 *
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 *
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 *
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 *
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * 返回表示最终状态的字符串。
 *
 *
 * 示例 1：
 *
 * 输入：dominoes = "RR.L"
 * 输出："RR.L"
 * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
 * 示例 2：
 *
 *
 * 输入：dominoes = ".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 *
 *
 * 提示：
 *
 * n == dominoes.length
 * 1 <= n <= 100000
 * dominoes[i] 为 'L'、'R' 或 '.'
 *
 *
 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestSolution838 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution838.class);


    static class Solution {
        private char[] dominoesChars;
        private int[] dominoesMidRet;//中间结果
        private char[] dominoesRet;//最终结果
        private int[] idxArray;
        private int[] valArray;
        private int dominoesLen;
        private int idxArrayLength;

        private List<Triple> sections;

        /**
         *
         * d3取值逻辑  1:向左 d1=-1 d2!=-1    2:向右 d1!=-1 d2=-1
         *
         */
        class Triple {
            private int d1;
            private int d2;
            private int d3;//方向: 1：左  2：右边 0：闭区间

            public Triple(int d1, int d2, int d3) {
                this.d1 = d1;
                this.d2 = d2;
                this.d3 = d3;
            }

            public int getD1() {
                return d1;
            }

            public int getD2() {
                return d2;
            }

            public int getD3() {
                return d3;
            }
        }

        /**
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：95 ms, 在所有 Java 提交中击败了7.42%的用户
         * 内存消耗：49.1 MB, 在所有 Java 提交中击败了21.81%的用户
         * 通过测试用例：
         * 43 / 43
         *
         * @param dominoes
         * @return
         */
        public String pushDominoes(String dominoes) {
            this.dominoesLen = dominoes.length();
            if (dominoesLen == 1) {
                return dominoes;
            }
            this.dominoesChars = dominoes.toCharArray();
            this.dominoesMidRet = new int[dominoesLen];//1左 2右
            this.dominoesRet = new char[dominoesLen];
            sections = new ArrayList<>();

            int count = 0;
            for (char dominoesChar : dominoesChars) {
                if (dominoesChar != '.') {
                    count ++;
                }
            }

            this.idxArrayLength = count;
            this.idxArray = new int[count];
            this.valArray = new int[count];
            int idx = 0;

            for (int i = 0; i < dominoesChars.length; i++) {
                char dominoesChar = dominoesChars[i];
                switch (dominoesChar) {
                    case 'L' :
                        valArray[idx] = 1;
                        idxArray[idx++] = i;
                        break;
                    case 'R' :
                        valArray[idx] = 2;
                        idxArray[idx++] = i;
                        break;
                    default:break;
                }
            }
            if (this.idxArrayLength == 0) {
                return dominoes;
            }
            //分离出区间
            buildSections();
            //计算
            doCalDominoes();
            //拼装结果
            String s = buildResult();
            return s;
        }

        /**
         * 计算
         */
        public void doCalDominoes() {
            int secSize = sections.size();
            if (secSize == 0) {
                return;
            }
            //处理头前和头
            Triple headTri = sections.get(0);
            if (headTri.getD3() == 1) {
                fillGap(0, headTri.getD2(), 1);
            } else if (headTri.getD3() == 0) {
                calCloseInterval(headTri.getD1(), headTri.getD2());
            } else {
                dominoesMidRet[headTri.getD1()] = 2;
            }

            //处理尾后
            Triple tailTri = sections.get(secSize-1);
            if (tailTri.getD3() == 2) {
                fillGap(tailTri.getD1() + 1, dominoesLen -1, 2);
            }else {}

            //从第二个开始
            for (int i = 1; i < secSize; i++) {
                Triple preTriple = sections.get(i - 1);
                Triple currentTriple = sections.get(i);

                switch (currentTriple.getD3()) {
                    case 0://闭区间
                        if (preTriple.getD3() == 2) {
                            fillGap(preTriple.getD1(), currentTriple.getD1(), 2);
                        }
                        //处理自己
                        calCloseInterval(currentTriple.getD1(), currentTriple.getD2());
                        break;
                    case 1://左
                        fillGap(preTriple.getD2(), currentTriple.getD2(), 1);
                        break;
                    case 2://右
                        if (preTriple.getD3() == 2) {
                            fillGap(preTriple.getD1(), currentTriple.getD1(), 2);
                        }
                        dominoesMidRet[currentTriple.getD1()] = 2;
                        break;
                }
            }

        }

        /**
         * 闭区间求解
         * @param idxStart
         * @param idxEnd
         */
        private void calCloseInterval(int idxStart, int idxEnd) {
            boolean flag = ((idxStart + idxEnd) & 0x1) == 0;
            int mid = (idxStart + idxEnd) >> 1;
            if (flag) {
                fillGap(idxStart, mid-1, 2);
                fillGap(mid + 1, idxEnd, 1);
                return;
            }
            fillGap(idxStart, mid, 2);
            fillGap(mid + 1, idxEnd, 1);
        }

        /**
         * [idxStart,idxEnd]区间批量赋值
         * @param idxStart
         * @param idxEnd
         * @param val
         */
        private void fillGap(int idxStart, int idxEnd, int val) {
            for (int i = idxStart; i <= idxEnd && (i < dominoesLen); i++) {
                dominoesMidRet[i] = val;
            }
        }

        /**
         * 拼装结果
         * @return
         */
        public String buildResult() {
            for (int i = 0; i < dominoesMidRet.length; i++) {
                switch (dominoesMidRet[i]) {
                    case 0:
                        dominoesRet[i] ='.';
                        break;
                    case 1:
                        dominoesRet[i] ='L';
                        break;
                    case 2:
                        dominoesRet[i] ='R';
                        break;
                }
            }
            return new String(dominoesRet);
        }

        /**
         * 分离出点、区间
         */
        public void buildSections() {
            Stack<Triple> stack = new Stack<>();
            stack.add(new Triple(valArray[0],idxArray[0], -1));
            for (int i = 1; i < idxArrayLength; i++) {
                int currVal = valArray[i];
                if (stack.isEmpty()) {
                    stack.push(new Triple(valArray[i],idxArray[i], -1));
                    continue;
                }

                Triple preTriple = stack.peek();
                int preDirect = preTriple.getD1();
                if (currVal == 1) {//左
                    if (preDirect == 1) {
                        //覆盖左
                        stack.pop();
                        sections.add(new Triple(-1, idxArray[i] , 1));
                    } else {
                        //右边
                        stack.pop();
                        sections.add(new Triple(preTriple.getD2(), idxArray[i]  ,0));
                    }
                } else {//右边
                    if (preDirect == 1) {
                        //左
                        stack.pop();
                        //出左加右
                        sections.add(new Triple(-1, preTriple.getD2() , 1));
                        stack.push(new Triple(valArray[i],idxArray[i], -1));
                    } else {
                        //两右，出右加右
                        stack.pop();
                        sections.add(new Triple(preTriple.getD2(),  -1, 2));
                        stack.push(new Triple(valArray[i], idxArray[i],  2));
                    }
                }
            }
            for (Triple triple : stack) {
                switch (triple.getD1()) {
                    case 1:
                        sections.add(new Triple(-1, triple.getD2() , 1));
                        break;
                    case 2:
                        sections.add(new Triple(triple.getD2(), -1  , 2));
                        break;
                }
            }

            return;
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().pushDominoes(".."));//..
        logger.info("{}", new Solution().pushDominoes("R."));//"RR"
        logger.info("{}", new Solution().pushDominoes("R"));//"R"
        logger.info("{}", new Solution().pushDominoes(".L.R."));//"LL.RR"
        logger.info("{}", new Solution().pushDominoes("RR.L"));//RR.L
        logger.info("{}", new Solution().pushDominoes(".L.R...LR..L.."));//LL.RR.LLRRLL..
    }
}
