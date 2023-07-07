/**
 * @Title: 1599.经营摩天轮的最大利润
 * @TitleSlug: maximumProfitOfOperatingACentennialWheel
 * @Author: Neo
 * @Date: 2023-03-05 11:43:51
 */
package leetcode.editor.cn;

import java.util.ArrayList;

public class 经营摩天轮的最大利润 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 经营摩天轮的最大利润().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            int n = customers.length;
            int cnt = 0;
            int i = 0;
            int tot = 0;
            int mx = 0;
            int ans = -1;
            while (i < n || cnt != 0) {
                cnt += i < n ? customers[i] : 0;
                if (cnt >= 4) {
                    tot += 4 * boardingCost - runningCost;
                    cnt -= 4;
                } else {
                    tot += cnt * boardingCost - runningCost;
                    cnt = 0;
                }
                i++;
                if (tot > mx) {
                    mx = tot;
                    ans = i;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
