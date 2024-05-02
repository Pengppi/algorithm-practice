/**
 * @Title: 857.雇佣 K 名工人的最低成本
 * @TitleSlug: minimumCostToHireKWorkers
 * @Author: Neo
 * @Date: 2024-05-02 16:54:09
 */
package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class 雇佣K名工人的最低成本minimumCostToHireKWorkers {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 雇佣K名工人的最低成本minimumCostToHireKWorkers().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            Integer[] ids = IntStream.range(0, quality.length).boxed()
                    .sorted((a, b) -> wage[a] * quality[b] - wage[b] * quality[a])
                    .toArray(Integer[]::new);
            
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            int sum = 0;
            for (int i = 0; i < k; i++) {
                int id = ids[i];
                pq.offer(quality[id]);
                sum += quality[id];
            }
            double ans = sum * ((double) wage[ids[k - 1]] / quality[ids[k - 1]]);
            for (int i = k; i < quality.length; i++) {
                int id = ids[i];
                if (quality[id] < pq.peek()) {
                    sum += quality[id] - pq.poll();
                    pq.offer(quality[id]);
                    ans = Math.min(ans, sum * ((double) wage[id] / quality[id]));
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       