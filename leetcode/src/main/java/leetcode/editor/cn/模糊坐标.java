/**
 * @Title: 816.模糊坐标
 * @TitleSlug: AmbiguousCoordinates
 * @Author: Neo
 * @Date: 2022-11-07 00:17:22
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 模糊坐标 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 模糊坐标().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> findSplit(String s) {
            List<String> res = new ArrayList<>();
            if (s.length() == 1 || s.charAt(0) != '0') {
                res.add(s);
            }
            if (s.charAt(s.length() - 1) == '0') {
                return res;
            }
            for (int i  = 1; i < s.length(); i++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i);
                if (s1.length() == 1 || s1.charAt(0) != '0') {
                    res.add(s1 + "." + s2);
                }
            }
            return res;
        }

        public List<String> ambiguousCoordinates(String s) {
            s = s.substring(1, s.length() - 1);
            List<String> ans = new ArrayList<>();
            for (int i = 1; i < s.length(); i++) {
                List<String> p1 = findSplit(s.substring(0, i));
                List<String> p2 = findSplit(s.substring(i));
                for (String s1 : p1) {
                    for (String s2 : p2) {
                        ans.add("(" + s1 + ", " + s2 + ")");
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
