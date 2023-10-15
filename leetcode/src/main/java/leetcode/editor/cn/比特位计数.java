/**
 * @Title: 338.比特位计数
 * @TitleSlug: countingBits
 * @Author: Neo
 * @Date: 2023-10-15 14:23:59
 */
package leetcode.editor.cn;

public class 比特位计数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 比特位计数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                int cnt = 0, x = i;
                while (x > 0) {
                    x &= (x - 1);
                    cnt++;
                }
                ans[i] = cnt;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       