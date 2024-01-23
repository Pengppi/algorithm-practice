/**
 * @Title: 2765.最长交替子数组
 * @TitleSlug: longestAlternatingSubarray
 * @Author: Neo
 * @Date: 2024-01-23 15:00:34
 */
package leetcode.editor.cn;

public class 最长交替子数组 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最长交替子数组().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int alternatingSubarray(int[] nums) {
            int n = nums.length;
            int i = 0, ans = -1;
            while (i < n - 1) {
                if (nums[i + 1] - nums[i] != 1) {
                    i++;
                    continue;
                }
                int start = i;
                i += 2;
                while (i < n && nums[i] == nums[i - 2]) {
                    i++;
                }
                ans = Math.max(ans, i - start);
                i--;
            }
            return ans;
        }
        
        private static int f1(final int[] nums) {
            int flg = 1, n = nums.length;
            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                int j = i + 1;
                flg = 1;
                while (j < n && nums[j] - nums[j - 1] == flg) {
                    j++;
                    flg = -flg;
                }
                ans = Math.max(ans, j - i);
            }
            return ans < 2 ? -1 : ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       