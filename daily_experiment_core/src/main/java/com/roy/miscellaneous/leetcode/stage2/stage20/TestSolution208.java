package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 */
public class TestSolution208 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution208.class);


    /**
     *
     * trie树（前缀树），常用于推荐系统
     *
     * 虽然说参考了网上的思路，但优化了他的写死的二维数组长度，用了javad的变长，<p>
     *     代码逻辑也是自己思考出来的，算是原创吧 变长还是引发一连串算法设计的，关键是要有图化的想象力，get了
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：51 ms, 在所有 Java 提交中击败了34.11%的用户
     * 内存消耗：47.8 MB, 在所有 Java 提交中击败了76.98%的用户
     *
     */
    static class Trie {
        private List<int[]> elementArrays;
        private BitSet color;//标记是否终节点
        private int nodeQty;//节点个数 ，节点个数是比边数大1

        /** Initialize your data structure here. */
        public Trie() {
            elementArrays = new ArrayList<int[]>();
            color= new BitSet();
        }

        /**
         * 扩容
         */
        private void resize() {
            int[] ints = new int[26];
            elementArrays.add(ints);
            this.nodeQty = elementArrays.size();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            int len = chars.length;
            int p = 0;


            //遍历 keyword
            for (int i = 0; i < len; i++) {
                int idx = chars[i]  - 'a';
                if (p+1 > nodeQty) {
                    resize();
                }
                int[] currentInts = elementArrays.get(p);
                if (currentInts[idx] ==0) {
                    resize();
                    currentInts[idx] = nodeQty -1;
                    p = nodeQty -1;
                } else {
                    p = currentInts[idx];
                }
            }
            color.set(p);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            int len = chars.length;
            int p = 0;
            if (this.nodeQty == 0) {
                return false;
            }

            //遍历 keyword
            int i;
            for (i = 0; i < len; i++) {
                int idx = chars[i]  - 'a';
                int[] currentInts = elementArrays.get(p);
                if (currentInts[idx] == 0) {
                    break;
                } else {
                    p = currentInts[idx];
                }
            }
            return color.get(p) && i == len;

        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            int len = chars.length;
            int p = 0;
            if (this.nodeQty == 0) {
                return false;
            }

            //遍历 keyword
            for (int i = 0; i < len; i++) {
                int idx = chars[i]  - 'a';
                int[] currentInts = elementArrays.get(p);
                if (currentInts[idx] ==0) {
                    return false;
                } else {
                    p = currentInts[idx];
                }
            }
            if (color.get(p)) return true;
            for (int i : elementArrays.get(p)) {
                if (i !=0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
//[null,null,false,false,true,true,false,true]

        trie.insert("hello");
        logger.info("{}", trie.search("helloa"));//false
        logger.info("{}", trie.search("hell"));//false



        logger.info("{}", trie.search("apple"));//false
        logger.info("{}", trie.startsWith("apple"));//false
        trie.insert("apple");
        logger.info("{}", trie.search("apple"));   // 返回 true
        logger.info("{}", trie.search("app"));     // 返回 false
        logger.info("{}", trie.search("apple"));     // 返回 true
        logger.info("{}", trie.startsWith("applec")); // 返回 false
        trie.insert("app");
        logger.info("{}", trie.search("app"));     // 返回 true


        trie.insert("abc");
        trie.insert("abc");
        trie.insert("ab");
        trie.insert("apple");
        logger.info("{}", trie.search("apple"));//true
        logger.info("{}", trie.search("abc"));//true
        logger.info("{}", trie.search("ab"));//true
        logger.info("{}", trie.startsWith("ab"));//true
    }
}
