/**
 * @Title: LCR 072.x 的平方根
 * @TitleSlug: jJ0w9p
 * @Author: Neo
 * @Date: 2024-03-07 14:20:21
 */
package leetcode.editor.cn;

public class X的平方根jJ0w9p {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new X的平方根jJ0w9p().new Solution();
        solution.mySqrt(2147483647);
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int l = 0, r = x;
            int ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if ((long) mid * mid <= x) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       