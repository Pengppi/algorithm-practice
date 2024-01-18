/**
 * @Title: 2171.拿出最少数目的魔法豆
 * @TitleSlug: removingMinimumNumberOfMagicBeans
 * @Author: Neo
 * @Date: 2024-01-18 09:27:23
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 拿出最少数目的魔法豆 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 拿出最少数目的魔法豆().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimumRemoval(int[] beans) {
            int n = beans.length;
            Arrays.sort(beans);
            long[] prefixSum = new long[n + 1], suffixSum = new long[n + 1];
            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + beans[i];
            }
            for (int i = n - 1; i >= 0; i--) {
                suffixSum[i] = suffixSum[i + 1] + beans[i];
            }
            long ans = prefixSum[n];
            for (int i = 0; i < n; i++) {
                if (i > 0 && beans[i] == beans[i - 1]) {
                    continue;
                }
                long sum = prefixSum[i] + suffixSum[i + 1] - (long) (n - 1 - i) * beans[i];
                ans = Math.min(ans, sum);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       