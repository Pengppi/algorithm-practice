/**
 * @Title: 150.逆波兰表达式求值
 * @TitleSlug: evaluateReversePolishNotation
 * @Author: Neo
 * @Date: 2023-12-09 17:41:23
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 逆波兰表达式求值 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 逆波兰表达式求值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> val = new ArrayDeque<>();
            for (String t : tokens) {
                if (t.length() > 1 || Character.isDigit(t.charAt(0))) {
                    val.push(Integer.valueOf(t));
                } else {
                    int b = val.pop(), a = val.pop();
                    switch (t) {
                        case "*":
                            val.push(a * b);
                            break;
                        case "/":
                            val.push(a / b);
                            break;
                        case "+":
                            val.push(a + b);
                            break;
                        case "-":
                            val.push(a - b);
                            break;
                    }
                }
            }
            return val.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       