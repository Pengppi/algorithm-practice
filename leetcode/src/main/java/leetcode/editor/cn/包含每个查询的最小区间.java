/**
 * @Title: 1851.包含每个查询的最小区间
 * @TitleSlug: minimumIntervalToIncludeEachQuery
 * @Author: Neo
 * @Date: 2023-07-18 23:41:03
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 包含每个查询的最小区间 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 包含每个查询的最小区间().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] minInterval(int[][] intervals, int[] queries) {
            Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
            int[][] q = new int[queries.length][2];
            for (int i = 0; i < queries.length; i++) {
                q[i][0] = queries[i];
                q[i][1] = i;
            }
            Arrays.sort(q, (a, b) -> (a[0] - b[0]));
            int[] ans = new int[queries.length];
            Arrays.fill(ans, -1);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));

            int idx = 0;
            for (int i = 0; i < queries.length; i++) {
                while (idx < intervals.length && q[i][0] >= intervals[idx][0]) {
                    pq.add(intervals[idx++]);
                }
                while (!pq.isEmpty() && pq.peek()[1] < q[i][0]) {
                    pq.poll();
                }
                if (!pq.isEmpty()) {
                    int[] t = pq.peek();
                    ans[q[i][1]] = t[1] - t[0] + 1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       