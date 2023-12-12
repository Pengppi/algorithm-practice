/**
 * @Title: 128.最长连续序列
 * @TitleSlug: longestConsecutiveSequence
 * @Author: Neo
 * @Date: 2023-12-12 14:25:30
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最长连续序列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int ans = 0;
            for (Integer x : set) {
                if (!set.contains(x - 1)) {
                    int cur = x;
                    int cnt = 1;
                    while (set.contains(cur + 1)) {
                        cur++;
                        cnt++;
                    }
                    ans = Math.max(ans, cnt);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       