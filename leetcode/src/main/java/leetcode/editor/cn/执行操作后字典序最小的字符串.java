/**
 * @Title: 1625.执行操作后字典序最小的字符串
 * @TitleSlug: lexicographicallySmallestStringAfterApplyingOperations
 * @Author: Neo
 * @Date: 2023-03-19 00:42:52
 */
package leetcode.editor.cn;

import java.util.TreeMap;
import java.util.TreeSet;

public class 执行操作后字典序最小的字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 执行操作后字典序最小的字符串().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        TreeSet<String> set;

        public String findLexSmallestString(String s, int a, int b) {
            set = new TreeSet<>();
            dfs(s, a, b);
            return set.first();
        }

        public void dfs(String s, int a, int b) {
            if (!set.contains(s)) {
                set.add(s);
                dfs(rotate(s, b), a, b);
                dfs(accumulate(s, a), a, b);
            }
        }

        public String accumulate(String s, int a) {
            char[] cs = s.toCharArray();
            for (int i = 1; i < cs.length; i += 2) {
                cs[i] = (char) ((cs[i] - '0' + a) % 10 + '0');
            }
            return new String(cs);
        }

        public String rotate(String s, int b) {
            b = b % s.length();
            return s.substring(s.length() - b) + s.substring(0, s.length() - b);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}
