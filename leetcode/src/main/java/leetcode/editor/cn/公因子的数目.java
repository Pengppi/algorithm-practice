/**
 * @Title: 2427.公因子的数目
 * @TitleSlug: numberOfCommonFactors
 * @Author: Neo
 * @Date: 2023-04-05 21:03:13
 */
package leetcode.editor.cn;

public class 公因子的数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 公因子的数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int commonFactors(int a, int b) {
            int t = gcd(a, b);
            int cnt = 0;
            for (int i = 1; i <= t; i++) {
                if (a % i == 0 && b % i == 0)
                    cnt++;
            }
            return cnt;
        }

        int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
