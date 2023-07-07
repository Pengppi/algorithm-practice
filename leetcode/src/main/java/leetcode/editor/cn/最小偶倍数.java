/**
 * @Title: 2413.最小偶倍数
 * @TitleSlug: smallestEvenMultiple
 * @Author: Neo
 * @Date: 2023-04-21 13:26:00
 */
package leetcode.editor.cn;

public class 最小偶倍数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最小偶倍数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestEvenMultiple(int n) {
            return n / gcd(n, 2) * 2;
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       