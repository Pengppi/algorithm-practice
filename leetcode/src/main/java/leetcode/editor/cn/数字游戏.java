/**
 * @Title: LCP 24.数字游戏
 * @TitleSlug: fiveTxKeK
 * @Author: Neo
 * @Date: 2024-02-01 23:37:17
 */
package leetcode.editor.cn;

import java.util.PriorityQueue;

public class 数字游戏 {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 数字游戏().new Solution();
        solution.numsGame(new int[]{3, 4, 5, 1, 6, 7});
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        public int[] numsGame(int[] nums) {
            final int MOD = (int) (1e9 + 7);
            int n = nums.length;
            int[] ans = new int[n];
            PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
            PriorityQueue<Integer> right = new PriorityQueue<>();
            long leftSum = 0, rightSum = 0;
            for (int i = 0; i < n; i++) {
                int x = nums[i] - i;
                if ((i & 1) == 1) {//长度是偶数
                    if (x > right.peek()) {
                        rightSum += x - right.peek();
                        right.offer(x);
                        x = right.poll();
                    }
                    left.offer(x);
                    leftSum += x;
                    ans[i] = (int) ((rightSum - leftSum) % MOD);
                } else {
                    if (!left.isEmpty() && x < left.peek()) {
                        leftSum -= left.peek() - x;
                        left.offer(x);
                        x = left.poll();
                    }
                    right.offer(x);
                    rightSum += x;
                    //中位数右边数之和rightSum-right.peek()减去左边数之和leftSum
                    ans[i] = (int) ((rightSum - right.peek() - leftSum) % MOD);
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       