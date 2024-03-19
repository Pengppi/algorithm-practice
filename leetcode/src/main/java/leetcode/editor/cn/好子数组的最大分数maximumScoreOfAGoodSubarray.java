/**
 * @Title: 1793.好子数组的最大分数
 * @TitleSlug: maximumScoreOfAGoodSubarray
 * @Author: Neo
 * @Date: 2024-03-19 09:18:56
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 好子数组的最大分数maximumScoreOfAGoodSubarray {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 好子数组的最大分数maximumScoreOfAGoodSubarray().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumScore(int[] nums, int k) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = nums.length;
            int[] right = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
                stack.push(i);
            }
            stack.clear();
            int ans = 0;
            
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                    stack.pop();
                }
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                stack.push(i);
                if (left <= k && right[i] >= k) {
                    ans = Math.max(ans, (right[i] - left + 1) * nums[i]);
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       