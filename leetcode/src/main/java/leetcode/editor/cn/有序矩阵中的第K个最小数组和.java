/**
 * @Title: 1439.有序矩阵中的第 k 个最小数组和
 * @TitleSlug: findTheKthSmallestSumOfAMatrixWithSortedRows
 * @Author: Neo
 * @Date: 2023-05-28 00:14:55
 */
package leetcode.editor.cn;

import java.util.PriorityQueue;

public class 有序矩阵中的第K个最小数组和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 有序矩阵中的第K个最小数组和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] mat, int k) {
            int[] a = new int[]{0};
            for (int[] b : mat) {
                a = kSmallestPairs(a, b, k);
            }
            return a[k - 1];
        }

        private int[] kSmallestPairs(int[] a, int[] b, int k) {
            int n = a.length, m = b.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
            int[] ans = new int[Math.min(n * m, k)];
            pq.add(new int[]{a[0] + b[0], 0, 0});
            int idx = 0;
            while (!pq.isEmpty() && idx < k) {
                int[] p = pq.poll();
                ans[idx++] = p[0];
                int i = p[1], j = p[2];
                if (j + 1 < m) {
                    pq.add(new int[]{a[i] + b[j + 1], i, j + 1});
                }
                if (i + 1 < n && j == 0) {
                    pq.add(new int[]{a[i + 1] + b[0], i + 1, 0});
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       