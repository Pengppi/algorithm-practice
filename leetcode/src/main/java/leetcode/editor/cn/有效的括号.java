/**
 * @Title: 20.有效的括号
 * @TitleSlug: validParentheses
 * @Author: Neo
 * @Date: 2024-01-02 13:53:52
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 有效的括号 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 有效的括号().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> st = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                switch (c) {
                    case ')':
                        if (st.isEmpty() || st.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (st.isEmpty() || st.pop() != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (st.isEmpty() || st.pop() != '{') {
                            return false;
                        }
                        break;
                    default:
                        st.push(c);
                        break;
                }
            }
            return st.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       