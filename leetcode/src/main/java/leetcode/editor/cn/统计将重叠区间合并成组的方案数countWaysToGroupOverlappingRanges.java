/**
 * @Title: 2580.统计将重叠区间合并成组的方案数
 * @TitleSlug: countWaysToGroupOverlappingRanges
 * @Author: Neo
 * @Date: 2024-03-27 00:08:18
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class 统计将重叠区间合并成组的方案数countWaysToGroupOverlappingRanges {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 统计将重叠区间合并成组的方案数countWaysToGroupOverlappingRanges().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countWays(int[][] ranges) {
            final int MOD = (int) (1e9 + 7);
            Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
            int mxR = -1, ans = 1;
            for (int[] p : ranges) {
                if (p[0] > mxR) {
                    ans = ans * 2 % MOD;
                }
                mxR = Math.max(mxR, p[1]);
            }
            return ans;
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
       