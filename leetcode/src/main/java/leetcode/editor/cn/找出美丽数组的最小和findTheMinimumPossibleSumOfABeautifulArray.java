/**
 * @Title: 2834.找出美丽数组的最小和
 * @TitleSlug: findTheMinimumPossibleSumOfABeautifulArray
 * @Author: Neo
 * @Date: 2024-03-08 23:53:51
 */
package leetcode.editor.cn;

public class 找出美丽数组的最小和findTheMinimumPossibleSumOfABeautifulArray {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 找出美丽数组的最小和findTheMinimumPossibleSumOfABeautifulArray().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumPossibleSum(int n, int target) {
            final int mod = (int) (1e9 + 7);
            int m = target >> 1;
            if (n <= m) {
                return (int) ((long) n * (n + 1) / 2 % mod);
            }
            return (int) (((long) m * (m + 1) / 2
                    + (2L * target + n - m - 1) * (n - m) / 2) % mod);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
