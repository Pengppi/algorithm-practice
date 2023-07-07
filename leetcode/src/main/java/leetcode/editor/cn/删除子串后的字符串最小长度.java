/**
 * @Title: 2696.删除子串后的字符串最小长度
 * @TitleSlug: minimumStringLengthAfterRemovingSubstrings
 * @Author: Neo
 * @Date: 2023-06-09 17:19:40
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 删除子串后的字符串最小长度 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 删除子串后的字符串最小长度().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minLength(String s) {
            return f2(s);
        }

        private int f1(String s) {
            while (s.contains("AB") || s.contains("CD")) {
                s = s.replace("AB", "");
                s = s.replace("CD", "");
            }
            return s.length();
        }

        private int f2(String s) {
            Deque<Character> d = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c == 'B') {
                    if (!d.isEmpty() && d.peekLast() == 'A') {
                        d.pollLast();
                    } else {
                        d.addLast(c);
                    }
                }else if (c == 'D') {
                    if (!d.isEmpty() && d.peekLast() == 'C') {
                        d.pollLast();
                    } else {
                        d.addLast(c);
                    }
                }else{
                    d.addLast(c);
                }
            }
            return d.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       