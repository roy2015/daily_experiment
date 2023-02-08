package com.guo.roy.research.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestTemp {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestTemp.class);


    static class Solution {
        private int[] tplData;
        private List<List<Integer>> result = new ArrayList<>();
        private int maxLevel;


        public void test1(int[] tplData) {
            maxLevel = tplData.length;
            this.tplData = tplData;

            List<List<Integer>> initDataList = new ArrayList<>();
            List<Integer> initData = new ArrayList<>();
            initDataList.add(initData);
            for (int i = 0; i < maxLevel; i++) {
                initData.add(0);
            }
            doTest(0, initDataList);
        }

        public void doTest(int level, List<List<Integer>> preLevelData) {
            if (level == maxLevel) {
                return;
            }
            int levelVal = tplData[level];
            List<List<Integer>> currentLevelData = new ArrayList<>();
            result.clear();
            for (int i = 0; i <= levelVal; i++) {
                List<List<Integer>> copyPreLevelData = new ArrayList<>();
                deepCopy(preLevelData, copyPreLevelData);
                for (List<Integer> copyPreLevelDatum : copyPreLevelData) {
                    copyPreLevelDatum.set(level, i);
                    result.add(copyPreLevelDatum);
                }
                currentLevelData.addAll(copyPreLevelData);
            }
            doTest(++level, currentLevelData);
        }

        private void deepCopy(List<List<Integer>> srcLists, List<List<Integer>> descLists) {
            for (List<Integer> srcList : srcLists) {
                List<Integer> addList = new ArrayList<>();
                descLists.add(addList);
                for (Integer integer : srcList) {
                    addList.add(new Integer(integer));
                }
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.test1(new int[]{1,2,1});
        logger.info("{}", solution.result);
    }
}
