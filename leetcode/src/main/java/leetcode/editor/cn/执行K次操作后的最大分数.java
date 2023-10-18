/**
 * @Title: 2530.执行 K 次操作后的最大分数
 * @TitleSlug: maximalScoreAfterApplyingKOperations
 * @Author: Neo
 * @Date: 2023-10-18 11:16:54
 */
package leetcode.editor.cn;

import java.util.PriorityQueue;

public class 执行K次操作后的最大分数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 执行K次操作后的最大分数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            for (int x : nums) {
                pq.offer(x);
            }
            long ans = 0;
            for (int i = 0; i < k; i++) {
                int p = pq.poll();
                ans += p;
                pq.offer((int) Math.ceil(p / 3.0));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       