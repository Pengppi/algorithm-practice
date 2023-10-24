/**
 * @Title: 2462.雇佣 K 位工人的总代价
 * @TitleSlug: totalCostToHireKWorkers
 * @Author: Neo
 * @Date: 2023-10-24 13:49:21
 */
package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class 雇佣K位工人的总代价 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 雇佣K位工人的总代价().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            LinkedList<Integer> list = new LinkedList<>();
            int n = costs.length;
            for (int i = 0; i < n; i++) {
                list.add(costs[i]);
            }
            long ans = 0;
            PriorityQueue<Integer> f = new PriorityQueue<>();
            PriorityQueue<Integer> l = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                while (list.size() > 0 && f.size() < candidates) {
                    f.add(list.removeFirst());
                }
                while (list.size() > 0 && l.size() < candidates) {
                    l.add(list.removeLast());
                }
                if (f.isEmpty()) {
                    ans += l.poll();
                } else if (l.isEmpty()) {
                    ans += f.poll();
                } else {
                    ans += f.peek() <= l.peek() ? f.poll() : l.poll();
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       