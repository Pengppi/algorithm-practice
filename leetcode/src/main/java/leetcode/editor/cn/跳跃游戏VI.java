/**
 * @Title: 1696.跳跃游戏 VI
 * @TitleSlug: jumpGameVi
 * @Author: Neo
 * @Date: 2024-02-05 13:14:03
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 跳跃游戏VI {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 跳跃游戏VI().new Solution();
        solution.maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2);
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            int[] f = Arrays.copyOf(nums, n);
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> f[o2] - f[o1]);
            queue.offer(0);
            for (int i = 1; i < n; i++) {
                while (queue.peek() < i - k) {
                    queue.poll();
                }
                f[i] += f[queue.peek()];
                queue.offer(i);
            }
            return f[n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       