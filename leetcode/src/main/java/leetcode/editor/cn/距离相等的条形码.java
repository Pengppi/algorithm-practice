/**
 * @Title: 1054.距离相等的条形码
 * @TitleSlug: distantBarcodes
 * @Author: Neo
 * @Date: 2023-05-14 00:13:21
 */
package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;

public class 距离相等的条形码 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 距离相等的条形码().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            int n = barcodes.length;
            if (n <= 2) {
                return barcodes;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int b : barcodes) {
                map.put(b, map.getOrDefault(b, 0) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
            for (Integer k : map.keySet()) {
                pq.offer(new int[]{k, map.get(k)});
            }

            int[] ans = new int[n];

            for (int i = 0; i < n; i++) {
                int[] p = pq.poll();
                if (i == 0 || ans[i - 1] != p[0]) {
                    ans[i] = p[0];
                    if (p[1] > 1) {
                        pq.offer(new int[]{p[0], p[1]-1});
                    }
                } else {
                    int[] next = pq.poll();
                    ans[i] = next[0];
                    if (next[1] > 1) {
                        pq.offer(new int[]{next[0], next[1]-1});
                    }
                    pq.offer(new int[]{p[0], p[1]});
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       