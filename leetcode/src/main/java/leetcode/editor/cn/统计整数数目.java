/**
 * @Title: 2719.统计整数数目
 * @TitleSlug: countOfIntegers
 * @Author: Neo
 * @Date: 2024-01-16 08:58:23
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 统计整数数目 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 统计整数数目().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int MOD = (int) (1e9 + 7);
        char[] arr1, arr2;
        int n, mx, mn;
        int[][] memo;
        
        public int count(String num1, String num2, int min_sum, int max_sum) {
            n = num2.length();
            mn = min_sum;
            mx = max_sum;
            num1 = "0".repeat(n - num1.length()) + num1;
            arr1 = num1.toCharArray();
            arr2 = num2.toCharArray();
            memo = new int[n][Math.min(9 * n, max_sum) + 1];
            Arrays.stream(memo).forEach(e -> Arrays.fill(e, -1));
            return dfs(0, 0, true, true);
        }
        
        private int dfs(int i, int sum, boolean downLimit, boolean upLimit) {
            if (sum > mx) {
                return 0;
            }
            if (i == n) {
                return sum >= mn ? 1 : 0;
            }
            if (!downLimit && !upLimit && memo[i][sum] != -1) {
                return memo[i][sum];
            }
            int lo = downLimit ? arr1[i] - '0' : 0;
            int hi = upLimit ? arr2[i] - '0' : 9;
            int res = 0;
            for (int d = lo; d <= hi; d++) {
                res = (res + dfs(i + 1, sum + d, downLimit && d == lo, upLimit && d == hi)) % MOD;
            }
            if (!downLimit && !upLimit) {
                memo[i][sum] = res;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       