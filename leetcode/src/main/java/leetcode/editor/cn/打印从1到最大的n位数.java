/**
 * @Title: 剑指 Offer 17.打印从1到最大的n位数
 * @TitleSlug: daYinCong1daoZuiDaDeNweiShuLcof
 * @Author: Neo
 * @Date: 2023-05-21 14:16:57
 */
package leetcode.editor.cn;

public class 打印从1到最大的n位数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 打印从1到最大的n位数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers(int n) {
            int max = (int) Math.pow(10, n) - 1;
            int[] ans = new int[max];
            for (int i = 0; i < max; i++) {
                ans[i] = i + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       