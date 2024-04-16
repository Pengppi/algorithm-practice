/**
 * @Title: 3113.边界元素是最大值的子数组数目
 * @TitleSlug: findTheNumberOfSubarraysWhereBoundaryElementsAreMaximum
 * @Author: Neo
 * @Date: 2024-04-16 23:27:10
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 边界元素是最大值的子数组数目findTheNumberOfSubarraysWhereBoundaryElementsAreMaximum {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 边界元素是最大值的子数组数目findTheNumberOfSubarraysWhereBoundaryElementsAreMaximum().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long numberOfSubarrays(int[] nums) {
            int n = nums.length;
            long ans = 0;
            Deque<int[]> stack = new ArrayDeque<>();
            
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[i] > stack.peek()[0]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek()[0] == nums[i]) {
                    ans += ++stack.peek()[1];
                } else {
                    stack.push(new int[]{nums[i], 1});
                    ans++;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       