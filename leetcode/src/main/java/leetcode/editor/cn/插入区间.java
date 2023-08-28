/**
 * @Title: 57.插入区间
 * @TitleSlug: insertInterval
 * @Author: Neo
 * @Date: 2023-08-28 09:53:25
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 插入区间 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 插入区间().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list = new ArrayList<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
            pq.offer(newInterval);
            for (int[] it : intervals) {
                pq.offer(it);
            }

            while (!pq.isEmpty()) {
                int[] p = pq.poll();
                while (!pq.isEmpty() && p[1] >= pq.peek()[0]) {
                    p[1] = Math.max(p[1], pq.poll()[1]);
                }
                list.add(p);
            }

            int sz = list.size();
            int[][] ans = new int[sz][2];
            for (int i = 0; i < sz; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       