/**
 * @Title: 100218.求出所有子序列的能量和
 * @TitleSlug: findTheSumOfSubsequencePowers
 * @Author: Neo
 * @Date: 2024-04-01 09:09:26
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class 求出所有子序列的能量和findTheSumOfSubsequencePowers {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 求出所有子序列的能量和findTheSumOfSubsequencePowers().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int inf = Integer.MAX_VALUE / 2, mod = (int) 1e9 + 7;
        private int[] nums;
        private HashMap<String, Integer> cache = new HashMap<>();
        
        public int sumOfPowers(int[] nums, int k) {
            Arrays.sort(nums);
            this.nums = nums;
            return dfs(nums.length - 1, k, inf, inf);
        }
        
        private int dfs(int i, int j, int pre, int minDiff) {
            if (j == 0) {
                return minDiff;
            }
            if (j > i + 1) {
                return 0;
            }
            String key = i + "_" + j + "_" + pre + "_" + minDiff;
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
            int res1 = dfs(i - 1, j, pre, minDiff);
            int res2 = dfs(i - 1, j - 1, nums[i], Math.min(minDiff, pre - nums[i]));
            int res = (res1 + res2) % mod;
            cache.put(key, res);
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       