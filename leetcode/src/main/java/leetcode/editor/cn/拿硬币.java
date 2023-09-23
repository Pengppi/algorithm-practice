/**
 * @Title: LCP 06.拿硬币
 * @TitleSlug: naYingBi
 * @Author: Neo
 * @Date: 2023-09-20 23:41:23
 */
package leetcode.editor.cn;

public class 拿硬币 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 拿硬币().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCount(int[] coins) {
            int ans = 0;
            for (int coin : coins) {
                ans += (coin + 1) / 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       