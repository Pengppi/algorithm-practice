/**
 * @Title: 1441.用栈操作构建数组
 * @TitleSlug: BuildAnArrayWithStackOperations
 * @Author: Neo
 * @Date: 2022-10-15 14:57:42
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 用栈操作构建数组 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 用栈操作构建数组().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> ans = new ArrayList<>();
            String p = "Push";
            String o = "Pop";
            int cur = 1;
            for (int i : target) {
                while (cur < i) {
                    ans.add(p);
                    ans.add(o);
                    cur++;
                }
                ans.add(p);
                cur++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
