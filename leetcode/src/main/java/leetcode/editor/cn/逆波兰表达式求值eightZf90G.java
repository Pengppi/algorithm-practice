/**
 * @Title: LCR 036.逆波兰表达式求值
 * @TitleSlug: eightZf90G
 * @Author: Neo
 * @Date: 2024-03-23 17:48:43
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 逆波兰表达式求值eightZf90G {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 逆波兰表达式求值eightZf90G().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> st = new ArrayDeque<>();
            for (String token : tokens) {
                try {
                    int num = Integer.parseInt(token);
                    st.push(num);
                } catch (Exception e) {
                    int b = st.pop(), a = st.pop();
                    switch (token) {
                        case "+":
                            st.push(a + b);
                            break;
                        case "-":
                            st.push(a - b);
                            break;
                        case "*":
                            st.push(a * b);
                            break;
                        case "/":
                            st.push(a / b);
                            break;
                    }
                }
            }
            return st.pop();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       