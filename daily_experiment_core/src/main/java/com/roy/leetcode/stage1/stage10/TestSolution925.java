package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/10.
 *
 *
 *你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。

 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

  

 示例 1：

 输入：name = "alex", typed = "aaleex"
 输出：true
 解释：'alex' 中的 'a' 和 'e' 被长按。
 示例 2：

 输入：name = "saeed", typed = "ssaaedd"
 输出：false
 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/long-pressed-name
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 这题有bug，如果输入是 "vtkgn"
 "vttkgnk"，所以题解都是错的
 *
 */
public class TestSolution925 {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution925.class);

    static class Solution {
        //"leelee"  ,  "lleeelee"
        public boolean isLongPressedName(String name, String typed) {
            int nameLen = name.toCharArray().length;
            int typedLen = typed.toCharArray().length;
            int nameI=0, typeI=0;

            char[] nameChars = name.toCharArray();
            char[] typedChars = typed.toCharArray();

            while (nameI < nameLen && typeI < typedLen) {
                if (nameChars[nameI] == typedChars[typeI]) {
                    nameI ++;
                    typeI ++;
                } else if(typeI > 0 && typedChars[typeI] == typedChars[typeI - 1]) {
                    typeI ++;
                } else return false;
            }
            return nameI == nameLen;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean eval = solution.isLongPressedName("vtkgn","vttkgnn");
        logger.info("{}",eval);
    }

}
