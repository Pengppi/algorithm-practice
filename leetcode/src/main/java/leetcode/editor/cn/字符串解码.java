/**
 * @Title: 394.字符串解码
 * @TitleSlug: decodeString
 * @Author: Neo
 * @Date: 2023-10-23 00:14:31
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 字符串解码 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 字符串解码().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            StringBuilder ans = new StringBuilder();
            int k = 0;
            Deque<Integer> num = new ArrayDeque<>();
            Deque<String> str = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    k = k * 10 + (c - '0');
                } else if (c == '[') {
                    num.addLast(k);
                    str.addLast(ans.toString());
                    k = 0;
                    ans = new StringBuilder();
                } else if (c == ']') {
                    StringBuilder t = new StringBuilder();
                    int kk = num.pollLast();
                    for (int i = 0; i < kk; i++) {
                        t.append(ans);
                    }
                    ans = new StringBuilder().append(str.pollLast()).append(t);
                } else {
                    ans.append(c);
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       