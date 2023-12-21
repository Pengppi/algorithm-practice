/**
 * @Title: 300.最长递增子序列
 * @TitleSlug: longestIncreasingSubsequence
 * @Author: Neo
 * @Date: 2023-12-22 00:58:34
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 最长递增子序列 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最长递增子序列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int ans = 1, n = nums.length;
            List<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                int index = lower_bound(list, nums[i]);
                if (index == list.size()) {
                    list.add(nums[i]);
                    ans = Math.max(ans, list.size());
                } else {
                    list.set(index, nums[i]);
                    ans = Math.max(ans, index + 1);
                }
            }
            return ans;
        }

        private int lower_bound(List<Integer> list, int t) {
            int l = 0, r = list.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (list.get(m) < t) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       