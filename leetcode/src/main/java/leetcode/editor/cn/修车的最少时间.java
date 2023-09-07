/**
 * @Title: 2594.修车的最少时间
 * @TitleSlug: minimumTimeToRepairCars
 * @Author: Neo
 * @Date: 2023-09-07 23:28:30
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 修车的最少时间 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 修车的最少时间().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long repairCars(int[] ranks, int cars) {
            int minR = Arrays.stream(ranks).min().getAsInt();
            long r = (long) minR * cars * cars, l = 0;
            while (l + 1 < r) {
                long m = (r + l) / 2;
                int cnt = 0;
                for (int x : ranks) {
                    cnt += Math.floor(Math.sqrt(m / x));
                }
                if (cnt >= cars) {
                    r = m;
                } else {
                    l = m;
                }
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       