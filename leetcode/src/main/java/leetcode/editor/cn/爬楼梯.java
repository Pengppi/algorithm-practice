/**
 * @Title: 70.爬楼梯
 * @TitleSlug: climbingStairs
 * @Author: Neo
 * @Date: 2023-12-10 22:51:20
 */
package leetcode.editor.cn;

public class 爬楼梯 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 爬楼梯().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            int[] f = new int[n + 1];
            f[0] = 1;
            f[1] = 1;
            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
            return f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       