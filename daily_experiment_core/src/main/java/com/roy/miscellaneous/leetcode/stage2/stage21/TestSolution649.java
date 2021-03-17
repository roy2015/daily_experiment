package com.roy.miscellaneous.leetcode.stage2.stage21;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/12
 *
 *
 * 649. Dota2 参议院
 * Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)
 *
 * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的一项：
 *
 * 禁止一名参议员的权利：
 *
 * 参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
 *
 * 宣布胜利：
 *
 *           如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
 *
 *
 *
 * 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
 *
 * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
 *
 * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。
 *
 *
 *
 * 示例 1：
 *
 * 输入："RD"
 * 输出："Radiant"
 * 解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。然后在第二轮的时候，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
 * 示例 2：
 *
 * 输入："RDD"
 * 输出："Dire"
 * 解释：
 * 第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
 * 第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
 * 第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
 * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
 *
 *
 * 提示：
 *
 * 给定字符串的长度在 [1, 10,000] 之间.
 *
 *
 */
public class TestSolution649 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution649.class);

    static class Human {
        private int rank;
        private String group;//Radiant or Dire

        public Human(int rank, String group) {
            this.rank = rank;
            this.group = group;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }
    }

    static class Solution {
        /**
         *
         * 执行用时不怎么理想，但还是搞出来了，"要杀去杀后面的人，可以自保，后面的没人杀了再去杀前面的人"，想不通为啥
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：1081 ms, 在所有 Java 提交中击败了5.04%的用户
         * 内存消耗：39.4 MB, 在所有 Java 提交中击败了26.57%的用户
         *
         * @param senate
         * @return
         */
        public String predictPartyVictory(String senate) {
            char _dChar = 'D';
            char rChar = 'R';
            String _dStr = "Dire";
            String _rStr = "Radiant";

            int length = senate.length();
            if (length ==1) {
                if (senate.equals(_dChar)) {
                    return _dStr;
                }
                else return _rStr;
            }

            char[] chars = senate.toCharArray();
            List<Human> humans = new ArrayList<>();

            //阵营分开
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (aChar == _dChar) {
                    humans.add(new Human(i+1, _dStr));
                } else {
                    humans.add(new Human(i+1, _rStr));
                }
            }
            //要杀去杀后面的人，可以自保，后面的没人杀了再去杀前面的人
            while (true) {
                for (int i = 0; i < humans.size(); i++) {
                    Human iHuman = humans.get(i);
                    if (iHuman.getRank() == -1) {
                        continue;
                    }
                    String iGroup = iHuman.getGroup();
                    String rdSwitch = _rStr;
                    boolean killed = false;
                    if (iGroup.equals(_rStr)) {
                        rdSwitch = _dStr;
                    }
                    for (int j = i + 1; j < humans.size(); j++) {
                        Human jVal = humans.get(j);
                        if (jVal.getGroup().equals(rdSwitch) && jVal.rank > -1) {
                            jVal.setRank(-1);
                            killed = true;
                            break;
                        }
                    }
                    if (!killed) {
                        for (int j = i - 1; j >= 0; j--) {
                            Human jVal = humans.get(j);
                            if (jVal.getGroup().equals(rdSwitch) && jVal.rank > -1) {
                                jVal.setRank(-1);
                                break;
                            }
                        }
                    }
                }
                humans = humans.stream().filter(x -> x.getRank() > -1).collect(Collectors.toList());
                if (humans.stream().collect(Collectors.groupingBy(x -> x.getGroup())).keySet().size() ==1) {
                    break;
                }
            }
            return humans.get(0).getGroup();
        }


        /**
         *
         * 未通过
         *
         * @param senate
         * @return
         */
        public String predictPartyVictory1(String senate) {
            char dChar = 'D';
            char rChar = 'R';
            String dStr = "Dire";
            String rStr = "Radiant";
            int max = 10000;

            int length = senate.length();
            if (length ==1) {
                if (senate.equals(dChar)) {
                    return dStr;
                }
                else return rStr;
            }

            char[] chars = senate.toCharArray();
            List<Integer> rList = new ArrayList<>();
            List<Integer> dList = new ArrayList<>();

            //阵营分开
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (aChar == dChar) {
                    dList.add(i +1);
                } else {
                    rList.add(i+1);
                }
            }

            //开始计算，N轮，直到有一方全部阵亡
            while (rList.size() > 0 && dList.size() > 0) {
                int r,d;
                int rKill = 0;
                int dKill = 0;
                r = d = 0;
                int rLen = rList.size();
                int dLen = dList.size();
                while (r < rLen || d < dLen ) {
                    int rVal = (r < rLen ? rList.get(r) : max);
                    int dVal = (d < dLen ? dList.get(d) : max);

                    if (rVal < dVal) {
                        dList.set(dKill, -1);
                        if (dKill== d) {
                            d ++;
                        }
                        dKill ++;
                        if (dKill == dLen) {
                            break;
                        }
                        r ++;
                    } else {
                        rList.set(rKill , -1);
                        if (rKill  == r) {
                            r ++;
                        }
                        rKill ++;
                        if (rKill == rLen) {
                            break;
                        }
                        d ++;
                    }
                }
                rList = rList.stream().filter(x -> x >= 0).collect(Collectors.toList());
                dList = dList.stream().filter(x -> x >= 0).collect(Collectors.toList());
            }

            if (rList.size() > 0) {
                return rStr;
            } else {
                return dStr;
            }

        }

        private String convertToRes(String candidateStr) {
            if (candidateStr.equals("D")) {
                return "Dire";
            }
            else return "Radiant";
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().predictPartyVictory("DDRRR"));//d
        logger.info("{}", new Solution().predictPartyVictory("DRRDRDRDRDDRDRDR"));//r
        logger.info("{}", new Solution().predictPartyVictory("DRRD"));//d
        logger.info("{}", new Solution().predictPartyVictory("DDRRRR"));//r
        logger.info("{}", new Solution().predictPartyVictory("RDRD"));//r
        logger.info("{}", new Solution().predictPartyVictory("RDD"));//d
    }
}
