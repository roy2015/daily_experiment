package com.roy.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/16.
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.

 示例 1:

 输入:
 3
 / \
 9  20
 /  \
 15   7
 输出: [3, 14.5, 11]
 解释:
 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution637 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution637.class);


    static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }



    static class Solution {
        /**
         * BFS  广度优先
         * 执行用时 :8 ms, 在所有 java 提交中击败了15.96%的用户
         内存消耗 :43.6 MB, 在所有 java 提交中击败了80.13%的用户
         *
         */
        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            int curLayout = 1, nextLayout =0;
            ArrayList<List<Integer>> lists = new ArrayList<>();
            ArrayList<Double> ret = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            ArrayList<Integer> list = new ArrayList<>();
            lists.add(list);

            while (! queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    nextLayout ++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLayout ++;
                }
                list.add(node.val);
                curLayout --;
                if (curLayout == 0) {
                    curLayout = nextLayout;
                    nextLayout = 0;
                    list = new ArrayList<>();
                    lists.add(list);
                }
            }

            //开始处理结果
            for (List<Integer> list1 : lists) {
                Long sum =0L;
                if (list1 != null && !list1.isEmpty()) {
                    for (Integer integer : list1) {
                        sum += integer;
                    }
                    ret.add(Double.valueOf(sum) / list1.size());
                }
            }

            return ret;
        }


        /**
         *
         * BFS 广度优先
         * 对上面的优化，去掉了大量的list，不过上面的结构比较清晰尤其是BSF的逻辑清楚
         *
         * 执行用时 :3 ms, 在所有 java 提交中击败了98.32%的用户
         内存消耗 :43.3 MB, 在所有 java 提交中击败了82.78%的用户
         * @param root
         * @return
         */
        public List<Double> averageOfLevels1(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            int curLayout = 1; // 当前层node计数
            int nextLayout =0; // 下一层node计数
            int curNodeCnt = 1;//当前层node 数目
            double curNodeValSum = 0d;////当前层node val的和

            ArrayList<Double> ret = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();//queue
            queue.offer(root);

            while (! queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    nextLayout ++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLayout ++;
                }
                curNodeValSum += node.val;
                curLayout --;
                if (curLayout == 0) {//一层的结束
                    ret.add(curNodeValSum / curNodeCnt);
                    curLayout = nextLayout;
                    curNodeCnt = nextLayout;
                    curNodeValSum = 0d;
                    nextLayout = 0;
                }
            }

            return ret;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        List<Double> result = new Solution().averageOfLevels(node);

        logger.info("{}");
    }

}
