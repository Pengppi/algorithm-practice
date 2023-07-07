/**
 * @Title: 剑指 Offer 46.把数字翻译成字符串
 * @TitleSlug: baShuZiFanYiChengZiFuChuanLcof
 * @Author: Neo
 * @Date: 2023-06-13 13:59:38
 */
package leetcode.editor.cn;

public class 把数字翻译成字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 把数字翻译成字符串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int n = s.length();
            int dp[] = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                int a = Integer.valueOf(s.substring(i - 2, i));
                if (a >= 10 && a <= 25) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       