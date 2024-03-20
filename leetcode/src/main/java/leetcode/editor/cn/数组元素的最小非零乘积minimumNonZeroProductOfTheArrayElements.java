/**
 * @Title: 1969.数组元素的最小非零乘积
 * @TitleSlug: minimumNonZeroProductOfTheArrayElements
 * @Author: Neo
 * @Date: 2024-03-20 16:41:44
 */
package leetcode.editor.cn;

public class 数组元素的最小非零乘积minimumNonZeroProductOfTheArrayElements {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 数组元素的最小非零乘积minimumNonZeroProductOfTheArrayElements().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int mod = 1_000_000_007;
        
        public int minNonZeroProduct(int p) {
            long k = (1L << p) - 1;
            return (int) (k % mod * quickPow(k - 1, p - 1) % mod);
        }
        
        
        private long quickPow(long x, int n) {
            long res = 1;
            x %= mod;
            while (n-- > 0) {
                res = res * x % mod;
                x = x * x % mod;
            }
            return res;
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}
       