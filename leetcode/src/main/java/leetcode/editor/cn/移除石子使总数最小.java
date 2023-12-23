/**
 * @Title: 1962.移除石子使总数最小
 * @TitleSlug: removeStonesToMinimizeTheTotal
 * @Author: Neo
 * @Date: 2023-12-23 00:21:47
 */
package leetcode.editor.cn;

import java.util.PriorityQueue;

public class 移除石子使总数最小 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 移除石子使总数最小().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minStoneSum(int[] piles, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            int n = piles.length, ans = 0;
            for (int i = 0; i < n; i++) {
                ans += piles[i];
                pq.offer(piles[i]);
            }
            for (int i = 0; i < k; i++) {
                int p = pq.poll();
                int rm = p / 2;
                ans -= rm;
                pq.offer(p - rm);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       