/**
 * @Title: 1790.仅执行一次字符串交换能否使两个字符串相等
 * @TitleSlug: CheckIfOneStringSwapCanMakeStringsEqual
 * @Author: Neo
 * @Date: 2022-10-11 09:33:38
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 仅执行一次字符串交换能否使两个字符串相等 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 仅执行一次字符串交换能否使两个字符串相等().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            List<Integer> idx = new ArrayList<>();
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    idx.add(i);
                }
            }
            if (idx.size() > 2 || idx.size() == 1) {
                return false;
            }
            if (idx.size() == 0) {
                return true;
            }
            return s1.charAt(idx.get(0)) == s2.charAt(idx.get(1)) && s1.charAt(idx.get(1)) == s2.charAt(idx.get(0));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
