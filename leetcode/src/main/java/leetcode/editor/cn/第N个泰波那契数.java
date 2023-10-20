/**
 * @Title: 1137.第 N 个泰波那契数
 * @TitleSlug: nThTribonacciNumber
 * @Author: Neo
 * @Date: 2023-10-19 15:19:07
 */
package leetcode.editor.cn;

public class 第N个泰波那契数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 第N个泰波那契数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1 || n == 2) {
                return 1;
            }
            int a = 0, b = 1, c = 1;
            for (int i = 3; i <= n; i++) {
                int t = a + b + c;
                a = b;
                b = c;
                c = t;
            }
            return c;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       