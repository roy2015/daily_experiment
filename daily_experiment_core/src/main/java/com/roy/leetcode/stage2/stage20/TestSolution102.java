package com.roy.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

import java.util.*;

/**
 *
 * 注意：这个比shwo me bug上难一点，这个是把每层分开了二维输出，那个是一维数组输出
 *
 * 102. 二叉树的层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestSolution102 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution102.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        /**
         * 执行结果：通过
         * 显示详情添加备注
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：41.4 MB, 在所有 Java 提交中击败了72.01%的用户
         * 通过测试用例：34 / 34
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            //本层，下层的计数，不会跨越三层只会两层
            int currentCounter =1;
            int nextCounter = 0;

            //计算本层层list
            List<Integer> currentList = new ArrayList<Integer>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                currentList.add(node.val);
                if (node.left !=null) {
                    nextCounter++;
                    queue.add(node.left);
                }
                if (node.right !=null) {
                    nextCounter++;
                    queue.add(node.right);
                }
                currentCounter--;
                //本层结束
                if (currentCounter == 0) {
                    result.add(currentList);
                    currentList = new ArrayList<Integer>();
                    currentCounter = nextCounter;
                    nextCounter = 0;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right= new TreeNode(20);
        node.right.left= new TreeNode(15);
        node.right.right= new TreeNode(17);

        List<List<Integer>> lists = new Solution().levelOrder(node);
        logger.info("{}", lists);
    }
}
