/**
 * @Title: 242.有效的字母异位词
 * @TitleSlug: validAnagram
 * @Author: Neo
 * @Date: 2023-11-28 13:00:25
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 有效的字母异位词 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 有效的字母异位词().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] s1 = s.toCharArray();
            char[] t1 = t.toCharArray();
            Arrays.sort(s1);
            Arrays.sort(t1);
            int n = s.length();
            for (int i = 0; i < n; i++) {
                if (s1[i] != t1[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       