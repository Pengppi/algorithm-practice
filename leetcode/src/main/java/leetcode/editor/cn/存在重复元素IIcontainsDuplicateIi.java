/**
 * @Title: 219.存在重复元素 II
 * @TitleSlug: containsDuplicateIi
 * @Author: Neo
 * @Date: 2024-04-29 15:45:19
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素IIcontainsDuplicateIi {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 存在重复元素IIcontainsDuplicateIi().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!set.add(nums[i])) {
                    return true;
                }
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       