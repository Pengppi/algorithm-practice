/**
 * @Title: 239.滑动窗口最大值
 * @TitleSlug: slidingWindowMaximum
 * @Author: Neo
 * @Date: 2023-06-10 15:19:56
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class 滑动窗口最大值{
public static void main(String[] args) {
        //测试代码
        Solution solution = new 滑动窗口最大值().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
        int i = 0;
        for (i = 0; i < k; i++) {
            pq.add(new int[]{i, nums[i]});
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = pq.peek()[1];
        for (; i < nums.length; i++) {
            pq.add(new int[]{i, nums[i]});
            while (pq.peek()[0] <= i - k) {
                pq.poll();
            }
            ans[i + 1 - k] = pq.peek()[1];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
        
       