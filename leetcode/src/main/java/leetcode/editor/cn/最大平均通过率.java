/**
 * @Title: 1792.最大平均通过率
 * @TitleSlug: MaximumAveragePassRatio
 * @Author: Neo
 * @Date: 2023-02-19 14:03:32
 */
package leetcode.editor.cn;

import java.util.PriorityQueue;

public class 最大平均通过率 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最大平均通过率().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                long val1 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
                long val2 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
                return Long.compare(val1, val2);
            });
            for (int[] c : classes) {
                pq.offer(c);
            }
            while (extraStudents-- > 0) {
                int[] c = pq.poll();
                c[0]++;
                c[1]++;
                pq.offer(c);
            }
            double res = 0;
            while (!pq.isEmpty()) {
                int[] c = pq.poll();
                res += (double) c[0] / c[1];
            }
            return res / classes.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
