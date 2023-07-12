/**
 * @Title: 2544.交替数字和
 * @TitleSlug: alternatingDigitSum
 * @Author: Neo
 * @Date: 2023-07-12 23:48:26
 */
package leetcode.editor.cn;

public class 交替数字和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 交替数字和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int alternateDigitSum(int n) {
            char[] cs = String.valueOf(n).toCharArray();
            int ans = 0, flg = 1;
            for (char c : cs) {
                int x = c - '0';
                ans += flg * x;
                flg = -flg;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       