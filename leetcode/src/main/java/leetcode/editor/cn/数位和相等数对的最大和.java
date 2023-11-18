/**
 * @Title: 2342.数位和相等数对的最大和
 * @TitleSlug: maxSumOfAPairWithEqualSumOfDigits
 * @Author: Neo
 * @Date: 2023-11-18 00:38:47
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数位和相等数对的最大和 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 数位和相等数对的最大和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSum(int[] nums) {
            int ans = -1, n = nums.length;
            Arrays.sort(nums);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = n - 1; i >= 0; i--) {
                int sum = getSum(nums[i]);
                if (map.containsKey(sum)) {
                    int j = map.get(sum);
                    ans = Math.max(ans, nums[i] + nums[j]);
                } else {
                    map.put(sum, i);
                }
            }
            return ans;
        }

        private int getSum(int x) {
            int res = 0;
            while (x > 0) {
                res += x % 10;
                x /= 10;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       