/**
 * @Title: LCP 30.魔塔游戏
 * @TitleSlug: p0NxJO
 * @Author: Neo
 * @Date: 2024-02-06 14:12:03
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 魔塔游戏 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 魔塔游戏().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int magicTower(int[] nums) {
            if (Arrays.stream(nums).sum() + 1 <= 0) {
                return -1;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            int cnt = 0;
            long cur = 1;
            for (int i = 0; i < nums.length; i++) {
                cur += nums[i];
                if (cur <= 0) {
                    if (queue.isEmpty() || queue.peek() > nums[i]) {
                        cur -= nums[i];
                    } else if (queue.peek() < nums[i]) {
                        cur -= queue.poll();
                        queue.offer(nums[i]);
                    }
                    cnt++;
                } else if (nums[i] < 0) {
                    queue.offer(nums[i]);
                }
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       