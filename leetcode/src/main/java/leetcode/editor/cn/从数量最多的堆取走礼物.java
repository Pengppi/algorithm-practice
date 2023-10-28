/**
 * @Title: 2558.从数量最多的堆取走礼物
 * @TitleSlug: takeGiftsFromTheRichestPile
 * @Author: Neo
 * @Date: 2023-10-28 00:18:30
 */
package leetcode.editor.cn;

import java.util.PriorityQueue;

public class 从数量最多的堆取走礼物 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 从数量最多的堆取走礼物().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long pickGifts(int[] gifts, int k) {
            long ans = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            for (int g : gifts) {
                ans += g;
                pq.offer(g);
            }
            for (int i = 0; i < k; i++) {
                int max = pq.poll();
                int left = (int) Math.sqrt(max);
                ans -= max - left;
                pq.offer(left);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       