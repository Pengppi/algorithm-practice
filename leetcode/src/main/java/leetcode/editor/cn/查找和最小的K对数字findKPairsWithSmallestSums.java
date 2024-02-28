/**
 * @Title: 373.查找和最小的 K 对数字
 * @TitleSlug: findKPairsWithSmallestSums
 * @Author: Neo
 * @Date: 2024-02-28 20:46:42
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 查找和最小的K对数字findKPairsWithSmallestSums {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 查找和最小的K对数字findKPairsWithSmallestSums().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            var ans = new ArrayList<List<Integer>>();
            int n = nums1.length, m = nums2.length;
            var queue = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));
            queue.offer(new int[]{nums1[0] + nums2[0], 0, 0});
            while (!queue.isEmpty() && ans.size() < k) {
                var cur = queue.poll();
                int i = cur[1], j = cur[2];
                ans.add(List.of(nums1[i], nums2[j]));
                if (j + 1 < m) {
                    queue.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                }
                if (j == 0 && i + 1 < n) {
                    queue.offer(new int[]{nums1[i + 1] + nums2[0], i + 1, 0});
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       