/**
 * @Title: 56.合并区间
 * @TitleSlug: mergeIntervals
 * @Author: Neo
 * @Date: 2023-08-27 11:15:12
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 合并区间 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 合并区间().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
            for (int[] interval : intervals) {
                queue.offer(interval);
            }
            List<int[]> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                while (!queue.isEmpty() && p[1] >= queue.peek()[0]) {
                    p[1] = Math.max(p[1], queue.poll()[1]);
                }
                list.add(p);
            }
            int[][] ans = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       