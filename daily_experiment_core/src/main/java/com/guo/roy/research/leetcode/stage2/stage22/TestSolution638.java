package com.guo.roy.research.leetcode.stage2.stage22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 *
 * 638. 大礼包
 * 在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 *
 * 给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。另有一个整数数组 needs 表示购物清单，其中 needs[i] 是需要购买第 i 件物品的数量。
 *
 * 还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。
 *
 * 返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
 *
 *
 *
 * 示例 1：
 *
 * 输入：price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
 * 输出：14
 * 解释：有 A 和 B 两种物品，价格分别为 ¥2 和 ¥5 。
 * 大礼包 1 ，你可以以 ¥5 的价格购买 3A 和 0B 。
 * 大礼包 2 ，你可以以 ¥10 的价格购买 1A 和 2B 。
 * 需要购买 3 个 A 和 2 个 B ， 所以付 ¥10 购买 1A 和 2B（大礼包 2），以及 ¥4 购买 2A 。
 * 示例 2：
 *
 * 输入：price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
 * 输出：11
 * 解释：A ，B ，C 的价格分别为 ¥2 ，¥3 ，¥4 。
 * 可以用 ¥4 购买 1A 和 1B ，也可以用 ¥9 购买 2A ，2B 和 1C 。
 * 需要买 1A ，2B 和 1C ，所以付 ¥4 买 1A 和 1B（大礼包 1），以及 ¥3 购买 1B ， ¥4 购买 1C 。
 * 不可以购买超出待购清单的物品，尽管购买大礼包 2 更加便宜。
 *
 *
 * 提示：
 *
 * n == price.length
 * n == needs.length
 * 1 <= n <= 6
 * 0 <= price[i] <= 10
 * 0 <= needs[i] <= 10
 * 1 <= special.length <= 100
 * special[i].length == n + 1
 * 0 <= special[i][j] <= 50
 *
 * @author guojun
 * @date 2021/6/11
 *
 *
 *
 * 看了题解思路，90%原创
 * 执行结果：
 * 通过
 * 显示详情
 * 添加备注
 *
 * 执行用时：
 * 514 ms
 * , 在所有 Java 提交中击败了
 * 7.88%
 * 的用户
 * 内存消耗：
 * 71.3 MB
 * , 在所有 Java 提交中击败了
 * 5.06%
 * 的用户
 * 通过测试用例：
 * 64 / 64
 */
public class TestSolution638 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution638.class);


    static class Solution {
        //需要的商品数目列表
        private List<Integer> needs;
        //需要的商品数目列表摊开
        private List<List<Integer>> needsLimits = new ArrayList<>();
        //过滤后的大礼包
        private List<List<Integer>> giftList = new ArrayList<>();
        //过滤后的大礼包种类数
        private int giftKindCount;
        //大礼包最多个数map
//        private Map<Integer, Integer> gift2GiftCountMap = new HashMap<>();
        //商品种类
        private int productKinds;

        public void doTest(int level, List<List<Integer>> preLevelData) {
            if (level == productKinds) {
                return;
            }
            int levelVal = needs.get(level);
            List<List<Integer>> currentLevelData = new ArrayList<>();
            needsLimits.clear();
            for (int i = 0; i <= levelVal; i++) {
                List<List<Integer>> copyPreLevelData = new ArrayList<>();
                deepCopy(preLevelData, copyPreLevelData);
                for (List<Integer> copyPreLevelDatum : copyPreLevelData) {
                    copyPreLevelDatum.set(level, i);
                    needsLimits.add(copyPreLevelDatum);
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
                    addList.add(integer);
                }
            }
        }

        private void deepCopy1(List<Integer> srcList, List<Integer> descList) {
            for (Integer integer : srcList) {
                descList.add(integer);
            }
        }

        //初始化商品个数限制二维数组
        private void initNeedLimits(List<Integer> needs) {
            productKinds = needs.size();
            this.needs = needs;

            List<List<Integer>> initDataList = new ArrayList<>();
            List<Integer> initData = new ArrayList<>();
            initDataList.add(initData);
            for (int i = 0; i < productKinds; i++) {
                initData.add(0);
            }
            doTest(0, initDataList);
        }

        //过滤不划算的和一个都用不了的礼包过滤掉
        private void filterGifts(List<Integer> price, List<List<Integer>> special) {
            for (int i = 0; i < special.size(); i++) {
                int normalPriceSum = 0;
                List<Integer> iGift = special.get(i);
                int iGiftSize = iGift.size();
                for (int j = 0; j < iGiftSize - 1; j++) {
                    normalPriceSum += iGift.get(j) * price.get(j);
                }
                if (normalPriceSum > iGift.get(iGiftSize - 1)) {
                    int giftMaxCount = getGiftMaxCount(iGift);
                    if (giftMaxCount > 0) {
                        giftList.add(iGift);
//                        gift2GiftCountMap.put(giftList.size() -1, giftMaxCount);
                    }
                }
            }
        }

        /**
         * 每种大礼包的最大数目
         */
        private int getGiftMaxCount(List<Integer> iGift) {
                //第i个礼包
                int k = 1 ;//礼包数量
                while (true) {
                    int j ;
                    //礼包里所有商品
                    for (j = 0; j < iGift.size() - 1; j++) {
                        //第j件商品数量
                        int jAmount = iGift.get(j) * k;
                        if (jAmount > needs.get(j)) {
                            break;
                        }
                    }
                    if (j == (iGift.size() - 1)) {
                        k ++;
                    } else {
                        k--;
                        break;
                    }
                }
                return k;
        }

        /**
         * 查找使用amount个k大礼包时的摊开数组index
         * @param amount
         * @return
         */
        private int getNeedLimitIdx(int amount, int k, int limit) {
            List<Integer> iGift = giftList.get(k);
            List<Integer> needsLimit = needsLimits.get(limit);
            List<Integer> iCopyNeed = new ArrayList<>();
            deepCopy1(needsLimit, iCopyNeed);
            for (int i = 0; i < iCopyNeed.size(); i++) {
                Integer iNeed = iCopyNeed.get(i);
                iNeed -= amount * iGift.get(i);
                if (iNeed < 0) {
                    return -1;
                }
                iCopyNeed.set(i, iNeed);
            }
            return findNeedLimitsIdx(iCopyNeed, limit);
        }

        private int getNeedLimitIdxExt(int amount, int k, int limit) {
            List<Integer> iGift = giftList.get(k);
            List<Integer> needsLimit = needsLimits.get(limit);
            for (int i = 0; i < needsLimit.size(); i++) {
                Integer iNeed = needsLimit.get(i);
                iNeed -= amount * iGift.get(i);
                if (iNeed < 0) {
                    return -1;
                }
            }

            //！=0
            int cmpSize = needsLimit.size();
            for (int i = 0; i < limit; i++) {
                List<Integer> needLimitC = needsLimits.get(i);
                int j;
                //比每一项
                for (j = 0; j < cmpSize; j++) {
                    Integer needCount = needsLimit.get(j);
                    Integer  kVal = needCount - amount * iGift.get(j);
                    if (!kVal.equals(needLimitC.get(j))) {
                        break;
                    }
                }
                if (j == cmpSize) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * 查找idx
         * @param targetList 传入需要比较的数组
         * @return
         */
        private int findNeedLimitsIdx(List<Integer> targetList, int limit) {
            int cmpSize = targetList.size();
            for (int i = 0; i < limit; i++) {
                List<Integer> needLimit = needsLimits.get(i);
                int j;
                for (j = 0; j < cmpSize; j++) {
                    Integer iVal = needLimit.get(j);
                    Integer jVal = targetList.get(j);
                    if (!iVal.equals(jVal)) {
                        break;
                    }
                }
                if (j == cmpSize) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * 查找idx
         * @param list2 传入需要比较的数组
         * @return
         */
        private int findNeedLimitsIdx1(List<Integer> list2, int limit) {
            for (int i = 0; i < limit; i++) {
                List<Integer> list1 = needsLimits.get(i);
                int gap = compareList(list2, list1);
                if (gap == 0) {
                    return i;
                } else if (gap  == 1) {
                    return -1;
                }
            }
            return -1;
        }

        private int compareList(List<Integer> list1, List<Integer> list2) {
            int k = 0;
            for (int i = 0; i < list1.size(); i++) {
                Integer val_1 = list1.get(i);
                Integer val_2 = list2.get(i);
                if (val_1.equals(val_2)) {
                    continue;
                }
                if ((val_1.intValue() - val_2.intValue()) > 0 ) {
                    k = k | 0x2;
                } else {
                    k = k | 0x1;
                }
            }
            return k;
        }

        /**
         * 计算总花费
         * @param prices
         * @param needsLimit
         * @return
         */
        private int computePrice(List<Integer> prices, List<Integer> needsLimit) {
            int sum = 0;
            int size = prices.size();
            for (int i = 0; i < size; i++) {
                sum += prices.get(i) * needsLimit.get(i);
            }
            return sum;
        }


        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            long start = System.currentTimeMillis();
            //准备工作
            initNeedLimits(needs);
            filterGifts(price, special);
            this.giftKindCount = giftList.size();

//            logger.info("start work.....................");
            //start work
            int[][] dp = new int[special.size() + 1][needsLimits.size()];
            //初始化第0行
            for (int i = 0; i < needsLimits.size(); i++) {
                List<Integer> needLimit = needsLimits.get(i);
                int sum = computePrice(price, needLimit);
                dp[0][i] = sum;
            }

            long end = System.currentTimeMillis();
//            logger.info("========== {} =========", (end - start));

            //前i个大礼包最小cost
            for (int i = 1; i <= giftKindCount; i++) {
                for (int j = 1; j < needsLimits.size(); j++) {
                    //不用大礼包
                    int minCost = dp[i-1][j];
//                    Integer iGiftMaxUse = gift2GiftCountMap.get(i-1);
                    //用1，2，。。。个大礼包
                    for (int k = 1; /*k <= iGiftMaxUse*/; k++) {
                        int idx = getNeedLimitIdx(k, i-1, j);
                        //返回-1的唯一可能是用不了
                        if (idx != -1) {
                            int tmpPrice = dp[i - 1][idx] + k * giftList.get(i-1).get(productKinds);
                            if (tmpPrice < minCost) {
                                minCost = tmpPrice;
                            }
                        } else {
                            break;
                        }
                    }
                    dp[i][j] = minCost;
                }
            }
            return dp[giftKindCount][needsLimits.size() -1];
        }
    }


    static class Solution1 {
        //需要的商品数目列表
        private List<Integer> needs;
        //需要的商品数目列表摊开
        private List<List<Integer>> needsLimits = new ArrayList<>();
        //过滤后的大礼包
        private List<List<Integer>> giftList = new ArrayList<>();
        //过滤后的大礼包种类数
        private int giftKindCount;
        //商品种类
        private int productKinds;
        int[] dp ;
        private List<Integer> price;


        public void doTest(int level, List<List<Integer>> preLevelData) {
            if (level == productKinds) {
                return;
            }
            int levelVal = needs.get(level);
            List<List<Integer>> currentLevelData = new ArrayList<>();
            needsLimits.clear();
            for (int i = 0; i <= levelVal; i++) {
                List<List<Integer>> copyPreLevelData = new ArrayList<>();
                deepCopy(preLevelData, copyPreLevelData);
                for (List<Integer> copyPreLevelDatum : copyPreLevelData) {
                    copyPreLevelDatum.set(level, i);
                    needsLimits.add(copyPreLevelDatum);
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
                    addList.add(integer);
                }
            }
        }

        private void deepCopy1(List<Integer> srcList, List<Integer> descList) {
            for (Integer integer : srcList) {
                descList.add(integer);
            }
        }

        //初始化商品个数限制二维数组
        private void initNeedLimits(List<Integer> needs) {
            productKinds = needs.size();
            this.needs = needs;

            List<List<Integer>> initDataList = new ArrayList<>();
            List<Integer> initData = new ArrayList<>();
            initDataList.add(initData);
            for (int i = 0; i < productKinds; i++) {
                initData.add(0);
            }
            doTest(0, initDataList);
        }

        //过滤不划算的和一个都用不了的礼包过滤掉
        private void filterGifts(List<Integer> price, List<List<Integer>> special) {
            for (int i = 0; i < special.size(); i++) {
                int normalPriceSum = 0;
                List<Integer> iGift = special.get(i);
                int iGiftSize = iGift.size();
                for (int j = 0; j < iGiftSize - 1; j++) {
                    normalPriceSum += iGift.get(j) * price.get(j);
                }
                if (normalPriceSum > iGift.get(iGiftSize - 1)) {
                    int giftMaxCount = getGiftMaxCount(iGift);
                    if (giftMaxCount > 0) {
                        giftList.add(iGift);
//                        gift2GiftCountMap.put(giftList.size() -1, giftMaxCount);
                    }
                }
            }
        }

        /**
         * 每种大礼包的最大数目
         */
        private int getGiftMaxCount(List<Integer> iGift) {
            //第i个礼包
            int k = 1 ;//礼包数量
            while (true) {
                int j ;
                //礼包里所有商品
                for (j = 0; j < iGift.size() - 1; j++) {
                    //第j件商品数量
                    int jAmount = iGift.get(j) * k;
                    if (jAmount > needs.get(j)) {
                        break;
                    }
                }
                if (j == (iGift.size() - 1)) {
                    k ++;
                } else {
                    k--;
                    break;
                }
            }
            return k;
        }

        /**
         * 查找使用amount个k大礼包时的摊开数组index
         * @param amount
         * @return
         */
        private int getNeedLimitIdx(int amount, int k, int limit) {
            List<Integer> iGift = giftList.get(k);
            List<Integer> needsLimit = needsLimits.get(limit);
            List<Integer> iCopyNeed = new ArrayList<>();
            deepCopy1(needsLimit, iCopyNeed);
            for (int i = 0; i < iCopyNeed.size(); i++) {
                Integer iNeed = iCopyNeed.get(i);
                iNeed -= amount * iGift.get(i);
                if (iNeed < 0) {
                    return -1;
                }
                iCopyNeed.set(i, iNeed);
            }
            return findNeedLimitsIdx(iCopyNeed, limit);
        }

        private int getNeedLimitIdxExt(int amount, int k, int limit) {
            List<Integer> iGift = giftList.get(k);
            List<Integer> needsLimit = needsLimits.get(limit);
            for (int i = 0; i < needsLimit.size(); i++) {
                Integer iNeed = needsLimit.get(i);
                iNeed -= amount * iGift.get(i);
                if (iNeed < 0) {
                    return -1;
                }
            }

            //！=0
            int cmpSize = needsLimit.size();
            for (int i = 0; i < limit; i++) {
                List<Integer> needLimitC = needsLimits.get(i);
                int j;
                //比每一项
                for (j = 0; j < cmpSize; j++) {
                    Integer needCount = needsLimit.get(j);
                    Integer  kVal = needCount - amount * iGift.get(j);
                    if (!kVal.equals(needLimitC.get(j))) {
                        break;
                    }
                }
                if (j == cmpSize) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * 查找idx
         * @param targetList 传入需要比较的数组
         * @return
         */
        private int findNeedLimitsIdx(List<Integer> targetList, int limit) {
            int cmpSize = targetList.size();
            for (int i = 0; i < limit; i++) {
                List<Integer> needLimit = needsLimits.get(i);
                int j;
                for (j = 0; j < cmpSize; j++) {
                    Integer iVal = needLimit.get(j);
                    Integer jVal = targetList.get(j);
                    if (!iVal.equals(jVal)) {
                        break;
                    }
                }
                if (j == cmpSize) {
                    return i;
                }
            }
            return -1;
        }

        private int compareList(List<Integer> list1, List<Integer> list2) {
            int k = 0;
            for (int i = 0; i < list1.size(); i++) {
                Integer val_1 = list1.get(i);
                Integer val_2 = list2.get(i);
                if (val_1.equals(val_2)) {
                    continue;
                }
                if ((val_1.intValue() - val_2.intValue()) > 0 ) {
                    k = k | 0x2;
                } else {
                    k = k | 0x1;
                }
            }
            return k;
        }

        /**
         * 计算总花费
         * @param prices  价格表
         * @param needsLimit 物品需求表
         * @return
         */
        private int computePrice(List<Integer> prices, List<Integer> needsLimit) {
            int sum = 0;
            int size = prices.size();
            for (int i = 0; i < size; i++) {
                sum += prices.get(i) * needsLimit.get(i);
            }
            return sum;
        }


        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            long start = System.currentTimeMillis();
            //准备工作
            initNeedLimits(needs);
            filterGifts(price, special);
            this.giftKindCount = giftList.size();

//            logger.info("start work.....................");
            //start work
            this.dp = new int[needsLimits.size()];
            this.price = price;

            doShoppingOffers(needsLimits.size()-1);
            return dp[needsLimits.size()-1];
        }


        private void doShoppingOffers(int needLimitsIdx) {
            if (needLimitsIdx == 0) {
                return ;
            }
            if (dp[needLimitsIdx] != 0) {
                return;
            }
            //不用
            List<Integer> needLimit = needsLimits.get(needLimitsIdx);
            int minCost = computePrice(price, needLimit);
            //用礼包
            for (int i = 0; i < giftList.size(); i++) {
                int idx = getNeedLimitIdx(1, i, needLimitsIdx);
                if (idx == -1) {
                    continue;
                }

                Integer giftCost = giftList.get(i).get(productKinds);
                doShoppingOffers(idx);
                int needLimitsIdxVal = dp[idx];
                int userGiftCost = giftCost + needLimitsIdxVal;
                if (userGiftCost < minCost) {
                    minCost = userGiftCost;
                }
            }
            dp[needLimitsIdx] = minCost;
        }
    }


    public static List<List<Integer>> toLists(int[][] arrays) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] array : arrays) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            for (int i : array) {
                list.add(i);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        logger.info("==============================");
        int[][] ints = new int[][] {
            {1,2,2,1,0,4,14},{6,3,4,0,0,1,16},{4,5,6,6,2,4,26},{1,1,4,3,4,3,15},{4,2,5,4,4,5,15},{4,0,0,2,3,5,13},{2,4,6,4,3,5,7},{3,3,4,2,2,6,21},{0,3,0,2,3,3,15},{0,2,4,2,2,5,24},{4,1,5,4,5,4,25},{6,0,5,0,1,1,14},{4,0,5,2,1,5,8},{4,1,4,4,3,1,10},{4,4,2,1,5,0,14},{2,4,4,1,3,1,16},{4,2,3,1,2,1,26},{2,4,1,6,5,3,2},{0,2,0,4,0,0,19},{3,1,6,3,3,1,23},{6,2,3,2,4,4,16},{5,3,5,5,0,4,5},{5,0,4,3,0,2,20},{5,3,1,2,2,5,8},{3,0,6,1,0,2,10},{5,6,6,1,0,4,12},{0,6,6,4,6,4,21},{0,4,6,5,0,0,22},{0,4,2,4,4,6,16},{4,2,1,0,6,5,14},{0,1,3,5,0,3,8},{5,5,3,3,2,0,4},{1,0,3,6,2,3,18},{4,2,6,2,2,5,2},{0,2,5,5,3,6,12},{1,0,6,6,5,0,10},{6,0,0,5,5,1,24},{1,4,6,5,6,3,19},{2,2,4,2,4,2,20},{5,6,1,4,0,5,3},{3,3,2,2,1,0,14},{0,1,3,6,5,0,9},{5,3,6,5,3,3,11},{5,3,3,1,0,2,26},{0,1,1,4,2,1,16},{4,2,3,2,1,4,6},{0,2,1,3,3,5,15},{5,6,4,1,2,5,18},{1,0,0,1,6,1,16},{2,0,6,6,2,2,17},{4,4,0,2,4,6,12},{0,5,2,5,4,6,6},{5,2,1,6,2,1,24},{2,0,2,2,0,1,14},{1,1,0,5,3,5,16},{0,2,3,5,5,5,6},{3,2,0,6,4,6,8},{4,0,1,4,5,1,6},{5,0,5,6,6,3,7},{2,6,0,0,2,1,25},{0,4,6,1,4,4,6},{6,3,1,4,1,1,24},{6,2,1,2,1,4,4},{0,1,2,3,0,1,3},{0,2,5,6,5,2,13},{2,6,4,2,2,3,17},{3,4,5,0,5,4,20},{6,2,3,4,1,3,4},{6,4,0,0,0,5,16},{3,1,2,5,0,6,11},{1,3,2,2,5,6,14},{1,3,4,5,3,5,18},{2,1,1,2,6,1,1},{4,0,4,0,6,6,8},{4,6,0,5,0,2,1},{3,1,0,5,3,2,26},{4,0,4,0,6,6,6},{5,0,0,0,0,4,26},{4,3,2,2,0,2,14},{5,2,4,0,2,2,26},{3,4,6,0,2,4,25},{2,1,5,5,1,3,26},{0,5,2,4,0,2,24},{5,2,5,4,5,0,1},{5,3,0,1,5,4,15},{6,1,5,1,2,1,21},{2,5,1,2,1,4,15},{1,4,4,0,0,0,1},{5,0,6,1,1,4,22},{0,1,1,6,1,4,1},{1,6,0,3,2,2,17},{3,4,3,3,1,5,17},{1,5,5,4,5,2,27},{0,6,5,5,0,0,26},{1,4,0,3,1,0,13},{1,0,3,5,2,4,5},{2,2,2,3,0,0,11},{3,2,2,1,1,1,6},{6,6,1,1,1,6,26},{1,5,1,2,5,2,12}
        };

        logger.info("{}", new Solution1().shoppingOffers(
            Arrays.asList(9,6,1,5,3,4),
            toLists(ints)
            ,  Arrays.asList(6,6,6,1,6,6)));

        logger.info("{}", new Solution1().shoppingOffers(
            Arrays.asList(2,3,4),
            Arrays.asList(
                Arrays.asList(1,1,0,4),
                Arrays.asList(2,2,1,9)
            ), Arrays.asList(1,2,1)));//11

        logger.info("{}", new Solution1().shoppingOffers(
            Arrays.asList(6,3,6,9,4,7),
            Arrays.asList(
                Arrays.asList(1,2,5,3,0,4,29),
                Arrays.asList(3,1,3,0,2,2,19)
            ),  Arrays.asList(4,1,5,2,2,4)));//69


        logger.info("{}", new Solution1().shoppingOffers(
            Arrays.asList(2,3),
            Arrays.asList(
                Arrays.asList(1,0,1),
                Arrays.asList(0,1,2)
            ), Arrays.asList(1,1)));//3


        logger.info("{}", new Solution1().shoppingOffers(
            Arrays.asList(2,5),
            Arrays.asList(
                Arrays.asList(3,0,5),
                Arrays.asList(1,2,10)
            ), Arrays.asList(3,2)));//14



    }
}
