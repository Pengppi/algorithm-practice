/**
 * @Title: LCP 33.蓄水
 * @TitleSlug: o8SXZn
 * @Author: Neo
 * @Date: 2023-05-21 13:32:59
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 蓄水 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 蓄水().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int storeWater(int[] bucket, int[] vat) {
            int maxStep = 0;
            int n = bucket.length;
            int ans = Integer.MAX_VALUE;
            int maxVat = Arrays.stream(vat).max().getAsInt();
            if (maxVat == 0) return 0;
            for (int k = 1; k <= maxVat && k < ans; k++) {
                int step = 0;
                for (int i = 0; i < n; i++) {
                    if (vat[i] == 0) continue;
                    double gap = Math.ceil(vat[i] / (double) k) - bucket[i];
                    step += gap > 0 ? gap : 0;
                }
                ans = Math.min(ans, step + k);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       