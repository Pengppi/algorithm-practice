/**
 * @Title: 345.反转字符串中的元音字母
 * @TitleSlug: reverseVowelsOfAString
 * @Author: Neo
 * @Date: 2023-10-28 00:24:38
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 反转字符串中的元音字母 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 反转字符串中的元音字母().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            int n = s.length();
            int l = 0, r = n - 1;
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('A');
            set.add('e');
            set.add('E');
            set.add('i');
            set.add('I');
            set.add('o');
            set.add('O');
            set.add('u');
            set.add('U');
            char[] cs = s.toCharArray();
            while (l < r) {
                while (l < n && !set.contains(cs[l])) {
                    l++;
                }
                while (r > 0 && !set.contains(cs[r])) {
                    r--;
                }
                if (l >= r) {
                    break;
                }
                char t = cs[l];
                cs[l] = cs[r];
                cs[r] = t;
                l++;
                r--;
            }
            return new String(cs);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       