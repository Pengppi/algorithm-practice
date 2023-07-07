/**
 * @Title: 862.和至少为 K 的最短子数组
 * @TitleSlug: ShortestSubarrayWithSumAtLeastK
 * @Author: Neo
 * @Date: 2022-10-26 11:49:02
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 和至少为K的最短子数组 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 和至少为K的最短子数组().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            long[] preSumArr = new long[n + 1];
            for (int i = 0; i < nums.length; i++) {
                preSumArr[i + 1] = preSumArr[i] + nums[i];
            }
            int ans = n + 1;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i <= n; i++) {
                long curSum = preSumArr[i];
                while (!deque.isEmpty() && curSum - preSumArr[deque.peekFirst()] >= k) {
                    ans = Math.min(ans, i - deque.pollFirst());
                }
                while (!deque.isEmpty() && preSumArr[deque.peekLast()] >= curSum) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            return ans < n + 1 ? ans : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
