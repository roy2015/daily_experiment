package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/23
 *
 * 606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 */
public class TestSolution606 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution606.class);


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        private static String EMPTY_STR = "()";
        private static String EMPTY_STR_1 = "(";
        private static String EMPTY_STR_2 = ")";


        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：8 ms, 在所有 Java 提交中击败了65.58%的用户
         * 内存消耗：40.4 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param t
         * @return
         */
        public String tree2str(TreeNode t) {
            if(t == null) {
                return "";
            }
            String retS = buildTree2str(t);
            //去掉外层的()
            return retS.substring(1, retS.length() -1);

        }

        public String buildTree2str(TreeNode t) {
            if(t == null) {
                return EMPTY_STR;
            }

            String leftStr = buildTree2str(t.left);
            String rightStr = buildTree2str(t.right);
            StringBuffer sb = new StringBuffer();
            sb.append(EMPTY_STR_1).append(t.val);
            if (rightStr.equals(EMPTY_STR)) {
                if (! leftStr.equals(EMPTY_STR)) {
                    sb.append(leftStr);
                } else {}
            } else {
                sb.append(leftStr).append(rightStr);
            }
            sb.append(EMPTY_STR_2);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        logger.info("{}", new Solution());
        logger.info("{}", new Solution().tree2str(node1));//1(2(4))(3)

        node2.left = null;
        node2.right = node4;
        logger.info("{}", new Solution().tree2str(node1));//1(2()(4))(3)
    }
}
