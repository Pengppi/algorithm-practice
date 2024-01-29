/**
 * @Title: 172.阶乘后的零
 * @TitleSlug: factorialTrailingZeroes
 * @Author: Neo
 * @Date: 2024-01-29 11:10:27
 */
package leetcode.editor.cn;

public class 阶乘后的零 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 阶乘后的零().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            int t = 5;
            int sum = 0;
            while (t <= n) {
                sum += n / t;
                t *= 5;
            }
            return sum;
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
        
       