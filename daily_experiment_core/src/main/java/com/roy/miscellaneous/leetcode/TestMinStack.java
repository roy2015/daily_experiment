package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;
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
 */
public class TestMinStack {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestMinStack.class);
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
                if ( x < assistStack.peek() ) {
                    assistStack.push(x);
                }
            }
        }

        public void pop() {
            Integer stackTop = targetStack.pop();
            Integer min = assistStack.peek();
            if (stackTop == min) {
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
                if (x < min) {
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
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();// 返回 -3.
        logger.info("{}", min);
        minStack.pop();
        int top = minStack.top();// 返回 0.
        logger.info("{}", top);
        min = minStack.getMin();// 返回 -2.
        logger.info("{}", min);


        PriorityQueue<Integer> integers = new PriorityQueue<>();


    }


}