/**
 * @Title: 373.查找和最小的 K 对数字
 * @TitleSlug: findKPairsWithSmallestSums
 * @Author: Neo
 * @Date: 2023-05-28 00:45:32
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 查找和最小的K对数字 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 查找和最小的K对数字().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums1.length, m = nums2.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
            pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
            while (!pq.isEmpty() && ans.size() < k) {
                int[] p = pq.poll();
                int i = p[1], j = p[2];
                ans.add(Arrays.asList(nums1[i], nums2[j]));
                if (j + 1 < m) {
                    pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                }
                if (j == 0 && i + 1 < n) {
                    pq.add(new int[]{nums1[i + 1] + nums2[0], i + 1, 0});
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       