/**
 * @Title: LCR 119.最长连续序列
 * @TitleSlug: WhsWhI
 * @Author: Neo
 * @Date: 2024-04-01 01:07:46
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 最长连续序列WhsWhI {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最长连续序列WhsWhI().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] fa, sz;
        
        public int longestConsecutive(int[] nums) {
            int n = nums.length;
            buildUnionFind(n);
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                if (map.containsKey(num)) {
                    continue;
                }
                int j = map.getOrDefault(num - 1, i);
                ans = Math.max(ans, union(i, j));
                j = map.getOrDefault(num + 1, i);
                ans = Math.max(ans, union(i, j));
                map.put(num, i);
            }
            return ans;
        }
        
        private void buildUnionFind(int n) {
            fa = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                sz[i] = 1;
            }
        }
        
        private int find(int x) {
            return x == fa[x] ? x : (fa[x] = find(fa[x]));
        }
        
        private int union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return sz[fx];
            }
            if (sz[fx] < sz[fy]) {
                int tmp = fx;
                fx = fy;
                fy = tmp;
            }
            fa[fy] = fx;
            sz[fx] += sz[fy];
            return sz[fx];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       