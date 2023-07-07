/**
 * @Title: 1590.使数组和能被 P 整除
 * @TitleSlug: makeSumDivisibleByP
 * @Author: Neo
 * @Date: 2023-04-17 15:33:09
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 使数组和能被P整除 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 使数组和能被P整除().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubarray(int[] nums, int p) {
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = (sum[i] + nums[i]) % p;
            }
            int t = sum[n];
            if (t == 0) {
                return 0;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int res = n;
            for (int i = 0; i <= n; i++) {
                map.put(sum[i], i);
                int j = map.getOrDefault((sum[i] - t + p) % p, -n);
                res = Math.min(res, i - j);
            }
            return res >= n ? -1 : res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

