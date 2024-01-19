/**
 * @Title: 2809.使数组和小于等于 x 的最少时间
 * @TitleSlug: minimumTimeToMakeArraySumAtMostX
 * @Author: Neo
 * @Date: 2024-01-19 09:04:11
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class 使数组和小于等于X的最少时间 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 使数组和小于等于X的最少时间().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
            int n = nums1.size(), sum1 = 0, sum2 = 0;
            int[][] pairs = new int[n][2];
            for (int i = 0; i < n; i++) {
                int a = nums1.get(i);
                int b = nums2.get(i);
                pairs[i][0] = a;
                pairs[i][1] = b;
                sum1 += a;
                sum2 += b;
            }
            Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
            int[] f = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int a = pairs[i][0];
                int b = pairs[i][1];
                for (int j = i + 1; j > 0; j--) {
                    f[j] = Math.max(f[j], f[j - 1] + a + b * j);
                }
            }
            for (int t = 0; t <= n; t++) {
                if (sum1 + sum2 * t - f[t] <= x) {
                    return t;
                }
            }
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       