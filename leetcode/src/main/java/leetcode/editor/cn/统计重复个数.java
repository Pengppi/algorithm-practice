/**
 * @Title: 466.统计重复个数
 * @TitleSlug: countTheRepetitions
 * @Author: Neo
 * @Date: 2024-01-02 13:03:22
 */
package leetcode.editor.cn;

public class 统计重复个数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 统计重复个数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            int[] dp = new int[s2.length()];
            for (int i = 0; i < s2.length(); i++) {
                int j = i;
                for (int p = 0; p < s1.length(); p++) {
                    if (s1.charAt(p) == s2.charAt(j)) {
                        j = (j + 1) % s2.length();
                        dp[i]++;
                    }
                }
            }
            int cnt = 0, p = 0;
            for (int i = 0; i < n1; i++) {
                int add = dp[p];
                p = (p + add) % s2.length();
                cnt += add;
            }
            return cnt / s2.length() / n2;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       