/**
 * @Title: 2404.出现最频繁的偶数元素
 * @TitleSlug: mostFrequentEvenElement
 * @Author: Neo
 * @Date: 2023-04-17 15:30:35
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 出现最频繁的偶数元素 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 出现最频繁的偶数元素().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mostFrequentEven(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 0) {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                }
            }
            int mx = 0, ans = Integer.MAX_VALUE;
            for (Integer k : map.keySet()) {
                if (map.get(k) > mx) {
                    ans = k;
                    mx = map.get(k);
                }
                if (map.get(k) == mx) {
                    ans = Math.min(ans, k);
                }

            }
            return map.isEmpty() ? -1 : ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

