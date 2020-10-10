package com.roy.miscellaneous.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guojun
 * @date 2020/10/10 16:39
 */
public class CommonUtils {


    /**
     *
     * example:
     *   List<List<Integer>> storeList = new ArrayList<>();
     *   getPermutation(3, 1, Arrays.asList(8,4,2,1), new ArrayList<>(), storeList);
     * 返回的数据在storeList
     *
     * 排列公式 p(n,k)= n!(n-k)!，返回所有的排列详情
     *  计算数学中排列(permutation and combination)的所有排列
     * @param k  选几个
     * @param level  传 1
     * @param calList 选择范围
     * @param parentList  new ArrayList<>()
     * @param storeList 接收的storeList
     */
    public void getPermutation(int k, int level, List<Integer> calList, List<Integer> parentList, List<List<Integer>> storeList) {
        if (calList == null || calList.isEmpty()) {
            return;
        }

        if (level == k) {
            List<Integer> copyParentList;
            for (Integer calVal : calList) {
                copyParentList = new ArrayList<>(parentList);
                copyParentList.add(calVal);
                storeList.add(copyParentList);
            }
            return;
        }

        int size = calList.size();
        for (int i = 0; i < size; i++) {
            List<Integer> nextCalList = new ArrayList<>(calList);
            nextCalList.remove(i);
            int currentVal = calList.get(i);
            List<Integer> nextParentList = new ArrayList<>(parentList);
            nextParentList.add(currentVal);
            getPermutation(k, level + 1, nextCalList, nextParentList, storeList);
        }
    }


    /**
     *
     *  计算数学中组合(combination)的所有组合详情
     *   example:
     *   List<List<Integer>> storeList = new ArrayList<>();
     *   getCombination(3, 1, Arrays.asList(8,4,2,1), new ArrayList<>(), storeList);
     *   返回的数据在storeList
     *
     * @param k  选几个
     * @param level  传 1
     * @param calList 选择范围
     * @param parentList  new ArrayList<>()
     * @param storeList 接收的storeList
     */
    public static void getCombination(int k, int level, List<Integer> calList, List<Integer> parentList, List<List<Integer>> storeList) {
        if (calList == null || calList.isEmpty()) {
            return;
        }

        if (level == k) {
            List<Integer> copyParentList;
            for (Integer calVal : calList) {
                copyParentList = new ArrayList<>(parentList);
                copyParentList.add(calVal);
                storeList.add(copyParentList);
            }
            return;
        }

        int size = calList.size();
        for (int i = 0; i < size; i++) {
            List<Integer> nextCalList = calList.subList(i + 1, size);
            int currentVal = calList.get(i);
            List<Integer> nextParentList = new ArrayList<>(parentList);
            nextParentList.add(currentVal);
            getCombination(k, level + 1, nextCalList, nextParentList, storeList);
        }
    }

    /**
     * 组合（combination）公式  C(n, k) =  n!/((n-k)!k!)
     * 只计算值没有详情
     *
     * @param n
     * @param k
     * @return
     */
    public static int calCombination(int n ,int k) {
        int a = 1, b =1;
        int i1 = n - k + 1;
        //p(n,k)
        for (int i = n; i >= i1 ; i--) {
            a *= i;
        }
        // p(k,k)
        for (int i = k; i >=1 ; i--) {
            b *= i;
        }
        return a /b;

    }
}
