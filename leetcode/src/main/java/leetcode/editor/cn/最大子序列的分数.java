/**
 * @Title: 2542.最大子序列的分数
 * @TitleSlug: maximumSubsequenceScore
 * @Author: Neo
 * @Date: 2023-11-03 14:44:06
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 最大子序列的分数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最大子序列的分数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxScore(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            Integer[] ids = new Integer[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
            }
            Arrays.sort(ids, (a, b) -> (nums2[b] - nums2[a]));
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long sum = 0;
            for (int i = 0; i < k - 1; i++) {
                int id = ids[i];
                sum += nums1[id];
                pq.offer(nums1[id]);
            }
            long ans = 0;
            for (int i = k - 1; i < n; i++) {
                int id = ids[i];
                sum += nums1[id];
                pq.offer(nums1[id]);
                ans = Math.max(ans, sum * nums2[id]);
                sum -= pq.poll();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       