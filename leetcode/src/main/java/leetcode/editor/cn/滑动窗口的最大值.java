/**
 * @Title: 剑指 Offer 59 - I.滑动窗口的最大值
 * @TitleSlug: huaDongChuangKouDeZuiDaZhiLcof
 * @Author: Neo
 * @Date: 2023-06-10 15:04:35
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 滑动窗口的最大值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> d = new ArrayDeque<>();
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            for (int i = 0; i < n; i++) {
                while (!d.isEmpty() && nums[i] >= nums[d.peekLast()]) {
                    d.pollLast();
                }
                d.addLast(i);
                while (d.peekFirst() <= i - k) {
                    d.pollFirst();
                }
                if (i + 1 - k >= 0) {
                    ans[i + 1 - k] = nums[d.peekFirst()];
                }
            }
            return ans;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       