/**
 * @Title: 1782.统计点对的数目
 * @TitleSlug: countPairsOfNodes
 * @Author: Neo
 * @Date: 2023-12-31 17:40:05
 */
package leetcode.editor.cn;

import java.util.*;

public class 统计点对的数目 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 统计点对的数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int[] countPairs(int n, int[][] edges, int[] queries) {
                List<Integer>[] g = new List[n];
                Arrays.setAll(g, e -> new ArrayList<>());
                Map<Integer, Integer> cntE = new HashMap<>();
                int[] deg = new int[n + 1];
                for (int[] e : edges) {
                    int x = Math.min(e[0], e[1]);
                    int y = Math.max(e[0], e[1]);
                    deg[x]++;
                    deg[y]++;
                    cntE.merge(x << 16 | y, 1, Integer::sum);
                }
                int[] ans = new int[queries.length];
                int[] sorted = deg.clone();
                Arrays.sort(sorted);
                for (int j = 0; j < queries.length; j++) {
                    int q = queries[j];
                    int l = 1, r = n;
                    while (l < r) {
                        if (sorted[l] + sorted[r] <= q) {
                            l++;
                        } else {
                            ans[j] += r - l;
                            r--;
                        }
                    }
                    for (Map.Entry<Integer, Integer> e : cntE.entrySet()) {
                        int k = e.getKey(), c = e.getValue();
                        int s = deg[k >> 16] + deg[k & 0xffff]; // 取出 k 的高 16 位和低 16 位
                        if (s > q && s - c <= q) {
                            ans[j]--;
                        }
                    }
                }
                return ans;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       