/**
 * @Title: LCP 50.宝石补给
 * @TitleSlug: WHnhjV
 * @Author: Neo
 * @Date: 2023-09-15 23:11:59
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 宝石补给 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 宝石补给().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int giveGem(int[] gem, int[][] operations) {
            for (int[] op : operations) {
                int x = op[0], y = op[1];
                int cnt = gem[x] / 2;
                gem[x] -= cnt;
                gem[y] += cnt;
            }
            return Arrays.stream(gem).max().getAsInt() - Arrays.stream(gem).min().getAsInt();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       