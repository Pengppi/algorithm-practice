/**
 * @Title: LCR 011.连续数组
 * @TitleSlug: A1NYOS
 * @Author: Neo
 * @Date: 2024-03-01 18:58:27
 */
package leetcode.editor.cn;

import java.util.HashMap;

public class 连续数组A1NYOS {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 连续数组A1NYOS().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            int n = nums.length, ans = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int counter = 0;
            for (int i = 0; i < n; i++) {
                counter += nums[i] == 1 ? 1 : -1;
                if (map.containsKey(counter)) {
                    ans = Math.max(ans, i - map.get(counter));
                } else {
                    map.put(counter, i);
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       