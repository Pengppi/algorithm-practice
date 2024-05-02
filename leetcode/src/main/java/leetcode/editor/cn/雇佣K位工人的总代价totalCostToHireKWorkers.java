/**
 * @Title: 2462.雇佣 K 位工人的总代价
 * @TitleSlug: totalCostToHireKWorkers
 * @Author: Neo
 * @Date: 2024-05-01 13:50:06
 */
package leetcode.editor.cn;

import java.util.PriorityQueue;

public class 雇佣K位工人的总代价totalCostToHireKWorkers {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 雇佣K位工人的总代价totalCostToHireKWorkers().new Solution();
        int[] costs = {18, 64, 12, 21, 21, 78, 36, 58, 88, 58, 99, 26, 92, 91, 53, 10, 24, 25, 20, 92, 73, 63, 51, 65, 87, 6, 17, 32, 14, 42, 46, 65, 43, 9, 75};
        int k = 13;
        int candidates = 23;
        long ans = solution.totalCost(costs, k, candidates);
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            int l = 0, r = costs.length - 1;
            while (l < candidates) {
                pq.offer(new int[]{l, costs[l]});
                l++;
            }
            while (r >= costs.length - candidates && r >= l) {
                pq.offer(new int[]{r, costs[r]});
                r--;
            }
            long ans = 0;
            for (int i = 0; i < k; i++) {
                int[] q = pq.poll();
                ans += q[1];
                if (l <= r) {
                    if (q[0] < l) {
                        pq.offer(new int[]{l, costs[l]});
                        l++;
                    } else {
                        pq.offer(new int[]{r, costs[r]});
                        r--;
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       