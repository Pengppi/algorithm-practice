/**
 * @Title: 剑指 Offer 14- I.剪绳子
 * @TitleSlug: jianShengZiLcof
 * @Author: Neo
 * @Date: 2023-05-11 14:55:53
 */
package leetcode.editor.cn;

import java.util.Map;

public class 剪绳子 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 剪绳子().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            if (n == 2)
                return 1;
            if (n == 3)
                return 2;
            int cnt = n / 3, mod = n % 3;
            int ans = (int) Math.pow(3, cnt);
            if (mod == 1) {
                ans = ans / 3 * 4;
            }
            if (mod == 2) {
                ans *= 2;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       