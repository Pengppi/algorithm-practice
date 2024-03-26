/**
 * @Title: LCR 061.查找和最小的 K 对数字
 * @TitleSlug: qn8gGX
 * @Author: Neo
 * @Date: 2024-03-26 11:19:45
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 查找和最小的K对数字qn8gGX {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 查找和最小的K对数字qn8gGX().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
            pq.offer(new int[]{0, 0});
            List<List<Integer>> ans = new ArrayList<>();
            while (ans.size() < k && !pq.isEmpty()) {
                int[] p = pq.poll();
                int i = p[0], j = p[1];
                ans.add(List.of(nums1[i], nums2[j]));
                if (i + 1 < nums1.length) {
                    pq.offer(new int[]{i + 1, j});
                }
                if (i == 0 && j + 1 < nums2.length) {
                    pq.offer(new int[]{0, j + 1});
                }
                
            }
            return ans;
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       