/**
 * @Title: 1094.拼车
 * @TitleSlug: carPooling
 * @Author: Neo
 * @Date: 2023-12-02 14:12:42
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 拼车 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 拼车().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
            int n = trips.length;
            Arrays.sort(trips, (a, b) -> (a[1] - b[1]));
            for (int i = 0; i < n; i++) {
                while (!pq.isEmpty() && pq.peek()[1] <= trips[i][1]) {
                    capacity += pq.poll()[0];
                }
                if (capacity < trips[i][0]) {
                    return false;
                }
                capacity -= trips[i][0];
                pq.offer(new int[]{trips[i][0], trips[i][2]});
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       