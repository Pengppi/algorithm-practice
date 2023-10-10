/**
 * @Title: 2731.移动机器人
 * @TitleSlug: movementOfRobots
 * @Author: Neo
 * @Date: 2023-10-10 12:47:11
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 移动机器人 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 移动机器人().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumDistance(int[] nums, String s, int d) {
            int n = nums.length;
            long[] list = new long[n];
            for (int i = 0; i < n; i++) {
                list[i] = nums[i] + (s.charAt(i) == 'L' ? -d : d);
            }
            Arrays.sort(list);
            long sum = 0, ans = 0;
            final int MOD = (int) 1e9 + 7;
            for (int i = 0; i < n; i++) {
                ans = (ans + i * list[i] - sum) % MOD;
                sum += list[i];
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       