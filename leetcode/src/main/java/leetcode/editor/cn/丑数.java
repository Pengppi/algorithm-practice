/**
 * @Title: 剑指 Offer 49.丑数
 * @TitleSlug: chouShuLcof
 * @Author: Neo
 * @Date: 2023-07-07 16:37:54
 */
package leetcode.editor.cn;

public class 丑数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 丑数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public int nthUglyNumber(int n) {
            int[] d = new int[n];
            d[0] = 1;
            int p2 = 0, p3 = 0, p5 = 0;
            for (int i = 1; i < n; i++) {
                int t2 = d[p2] * 2;
                int t3 = d[p3] * 3;
                int t5 = d[p5] * 5;
                d[i] = Math.min(t2, Math.min(t3, t5));
                if (d[i] == t2) {
                    p2++;
                }
                if (d[i] == t3) {
                    p3++;
                }
                if (d[i] == t5) {
                    p5++;
                }
            }
            return d[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       