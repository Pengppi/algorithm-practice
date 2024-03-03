/**
 * @Title: LCR 038.每日温度
 * @TitleSlug: iIQa4I
 * @Author: Neo
 * @Date: 2024-03-03 11:05:29
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 每日温度iIQa4I {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 每日温度iIQa4I().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] ans = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       