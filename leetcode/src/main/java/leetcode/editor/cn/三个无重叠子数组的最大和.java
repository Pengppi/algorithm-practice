/**
 * @Title: 689.三个无重叠子数组的最大和
 * @TitleSlug: maximumSumOf3NonOverlappingSubarrays
 * @Author: Neo
 * @Date: 2023-11-19 00:07:42
 */
package leetcode.editor.cn;


public class 三个无重叠子数组的最大和 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 三个无重叠子数组的最大和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int n = nums.length;
            long[] sum = new long[n + 1];
            reverse(nums);
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
            long[][] f = new long[n + 1][4];
            for (int i = k; i <= n; i++) {
                for (int j = 1; j < 4; j++) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - k][j - 1] + sum[i] - sum[i - k]);
                }
            }
            int[] ans = new int[3];
            int i = n, j = 3, idx = 0;
            while (j > 0) {
                if (f[i - 1][j] > f[i - k][j - 1] + sum[i] - sum[i - k]) {
                    i--;
                } else {
                    ans[idx++] = n - i;
                    i -= k;
                    j--;
                }
            }
            return ans;
        }

        private void reverse(int[] nums) {
            int n = nums.length;
            int l = 0, r = n - 1;
            while (l < r) {
                int c = nums[l];
                nums[l++] = nums[r];
                nums[r--] = c;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       