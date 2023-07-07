/**
 * @Title: 面试题 17.09.第 k 个数
 * @TitleSlug: GetKthMagicNumberLcci
 * @Author: Neo
 * @Date: 2022-09-28 14:37:04
 */
package leetcode.editor.cn;

public class 第K个数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 第K个数().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /* public int getKthMagicNumber(int k) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            pq.add(1L);
            int cnt = 0;
            while (++cnt != k) {
                long t = pq.poll();
                long t3 = t * 3, t5 = t * 5, t7 = t * 7;
                if (!pq.contains(t3)) {
                    pq.add(t3);
                }
                if (!pq.contains(t5)) {
                    pq.add(t5);
                }
                if (!pq.contains(t7)) {
                    pq.add(t7);
                }
            }
            return Math.toIntExact(pq.poll());
        } */

        public int getKthMagicNumber(int k) {
            int[] dp = new int[k + 1];
            dp[1] = 1;
            int p3 = 1, p5 = 1, p7 = 1;
            for (int i = 2; i <= k; i++) {
                int t3 = dp[p3] * 3, t5 = dp[p5] * 5, t7 = dp[p7] * 7;
                dp[i] = Math.min(t3, Math.min(t5, t7));
                if (dp[i] == t3) {
                    p3++;
                }
                if (dp[i] == t5) {
                    p5++;
                }
                if (dp[i] == t7) {
                    p7++;
                }
            }
            return dp[k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
