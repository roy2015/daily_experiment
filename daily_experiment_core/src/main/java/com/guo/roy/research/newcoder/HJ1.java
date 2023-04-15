package com.guo.roy.research.newcoder;

import java.util.Scanner;

/**
 * 找出最后一个单词的长度
 * @author guojun
 * @date 2023/3/14 15:05
 */
public class HJ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String line = in.nextLine();
            char[] chars = line.toCharArray();
            int length = chars.length;
            int cnt =0;
            for (int i = length-1; i >= 0; i--) {
                if (chars[i] != ' ') {
                    cnt++;
                } else {
                    break;
                }
            }
            System.out.println(cnt);
        }
    }

}
