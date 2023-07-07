/**
 * @Title: 1684.统计一致字符串的数目
 * @TitleSlug: CountTheNumberOfConsistentStrings
 * @Author: Neo
 * @Date: 2022-11-08 08:47:00
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 统计一致字符串的数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 统计一致字符串的数目().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            Set<Character> set = new HashSet<>();
            for (char c : allowed.toCharArray()) {
                set.add(c);
            }
            int cnt = 0;
            for (String word : words) {
                boolean flg = true;
                for (char c : word.toCharArray()) {
                    if (!set.contains(c)) {
                        flg = false;
                        break;
                    }
                }
                if (flg) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
