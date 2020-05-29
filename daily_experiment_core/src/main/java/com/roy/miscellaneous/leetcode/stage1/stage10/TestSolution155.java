package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * 最小栈
 *
 * 两种实现
 * 1. MinStack 辅助栈
 * 2. MinStack1 不用辅助栈，但元素数量*2，空间换时间
 * 总结： 2虽然是一个栈，但总元素数据还是比用辅助栈的多，孰优孰劣？
 *
 * Created by apple on 2019/9/1.
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 示例:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.getMin();   --> 返回 -2.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/min-stack
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution155 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution155.class);


    /**
     * 执行用时 :66 ms, 在所有 java 提交中击败了85.28%的用户
     * 内存消耗 :39.9 MB, 在所有 java 提交中击败了95.99%的用户
     */
    static class MinStack {
        private Stack<Integer> targetStack ;
        private Stack<Integer> assistStack;

        /** initialize your data structure here. */
        public MinStack() {
            targetStack = new Stack<Integer>();
            assistStack = new Stack<Integer>();
        }

        public void push(int x) {
            targetStack.push(x);
            if (assistStack.isEmpty()) {
                assistStack.push(x);
            } else {
                if ( x <= assistStack.peek() ) {
                    assistStack.push(x);
                }
            }
        }

        public void pop() {
            Integer stackTop = targetStack.pop();
            Integer min = assistStack.peek();
            if (stackTop.equals(min)) {
                assistStack.pop();
            }
        }

        public int top() {
            return targetStack.peek();
        }

        public int getMin() {
            return assistStack.peek();
        }

    }

    /**
     * 执行用时 :64 ms, 在所有 java 提交中击败了88.01%的用户
     * 内存消耗 :40.3 MB, 在所有 java 提交中击败了95.44%的用户
     */
    static class MinStack1 {
        private Stack<Integer> targetStack ;

        /** initialize your data structure here. */
        public MinStack1() {
            targetStack = new Stack<Integer>();
        }

        public void push(int x) {
            if (targetStack.isEmpty()) {
                targetStack.push(x);
                targetStack.push(x);
            } else {
                Integer min = targetStack.peek();
                targetStack.push(x);
                if (x <= min) {
                    targetStack.push(x);
                } else {
                    targetStack.push(min);
                }
            }
        }

        public void pop() {
            targetStack.pop();
            targetStack.pop();
        }

        public int top() {
            Integer top = targetStack.pop();
            Integer peek = targetStack.peek();
            targetStack.push(top);
            return peek;
        }

        public int getMin() {
            return targetStack.peek();
        }

    }

    public static void main(String[] args) {
//        MinStack minStack = new MinStack();
        MinStack minStack = new MinStack();
//        logger.info("{}", minStack.getMin());
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);

        minStack.pop();
        logger.info("{}", minStack.getMin());
        minStack.pop();
        logger.info("{}", minStack.getMin());
        minStack.pop();
        logger.info("{}", minStack.getMin());




    }


}
