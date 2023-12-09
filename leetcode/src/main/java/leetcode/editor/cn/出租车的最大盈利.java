/**
 * @Title: 2008.出租车的最大盈利
 * @TitleSlug: maximumEarningsFromTaxi
 * @Author: Neo
 * @Date: 2023-12-08 00:08:40
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 出租车的最大盈利 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 出租车的最大盈利().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxTaxiEarnings(int n, int[][] rides) {
            Arrays.sort(rides, (a, b) -> (a[1] - b[1]));
            long[] f = new long[n + 1];
            int j = 0;
            for (int i = 1; i <= n; i++) {
                f[i] = f[i - 1];
                while (j < rides.length && i == rides[j][1]) {
                    int s = rides[j][0], e = rides[j][1];
                    f[i] = Math.max(f[i], f[s] + e - s + rides[j][2]);
                    j++;
                }
            }
            return f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       