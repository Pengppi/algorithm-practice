/**
 * @Title: LCR 057.存在重复元素 III
 * @TitleSlug: sevenWqeDu
 * @Author: Neo
 * @Date: 2024-03-18 09:24:43
 */
package leetcode.editor.cn;

import java.util.TreeSet;

public class 存在重复元素IIIsevenWqeDu {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 存在重复元素IIIsevenWqeDu().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            TreeSet<Long> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                Long ceil = set.ceiling((long) nums[i] - t);
                if (ceil != null && ceil <= (long) nums[i] + t) {
                    return true;
                }
                set.add((long) nums[i]);
                if (i >= k) {
                    set.remove((long) nums[i - k]);
                }
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       