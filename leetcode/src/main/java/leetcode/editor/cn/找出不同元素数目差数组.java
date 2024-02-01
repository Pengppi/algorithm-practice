/**
 * @Title: 2670.找出不同元素数目差数组
 * @TitleSlug: findTheDistinctDifferenceArray
 * @Author: Neo
 * @Date: 2024-01-31 09:29:14
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 找出不同元素数目差数组 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 找出不同元素数目差数组().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] distinctDifferenceArray(int[] nums) {
            int n = nums.length;
            int[] diff = new int[n];
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(nums[i]);
                diff[i] = set.size();
            }
            set.clear();
            for (int i = n - 1; i >= 0; i--) {
                diff[i] -= set.size();
                set.add(nums[i]);
            }
            return diff;
            
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
        
       