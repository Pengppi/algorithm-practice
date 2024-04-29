/**
 * @Title: 264.丑数 II
 * @TitleSlug: uglyNumberIi
 * @Author: Neo
 * @Date: 2024-04-29 15:10:49
 */
package leetcode.editor.cn;

public class 丑数IIuglyNumberIi {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 丑数IIuglyNumberIi().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] f = new int[n];
            int p1 = 0, p2 = 0, p3 = 0;
            f[0] = 1;
            for (int i = 1; i < n; i++) {
                int num1 = f[p1] * 2, num2 = f[p2] * 3, num3 = f[p3] * 5;
                f[i] = Math.min(Math.min(num1, num2), num3);
                if (f[i] == num1) {
                    p1++;
                }
                if (f[i] == num2) {
                    p2++;
                }
                if (f[i] == num3) {
                    p3++;
                }
            }
            return f[n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       