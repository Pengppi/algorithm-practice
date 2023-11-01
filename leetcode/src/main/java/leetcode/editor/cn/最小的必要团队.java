/**
 * @Title: 1125.最小的必要团队
 * @TitleSlug: smallestSufficientTeam
 * @Author: Neo
 * @Date: 2023-11-01 17:37:14
 */
package leetcode.editor.cn;

import java.util.*;

public class 最小的必要团队 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最小的必要团队().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private long all;
        private int[] mask;

        private long[][] memo;

        public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
            HashMap<String, Integer> skillToIndex = new HashMap<>();
            int m = req_skills.length;
            for (int i = 0; i < m; i++) {
                skillToIndex.put(req_skills[i], i);
            }
            int n = people.size();
            mask = new int[n];
            for (int i = 0; i < n; i++) {
                for (String s : people.get(i)) {
                    mask[i] |= 1 << skillToIndex.get(s);
                }
            }

            int u = 1 << m;
            memo = new long[n][u];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], -1);
            }
            all = (1L << n) - 1;
            long res = dfs(n - 1, u - 1);
            int[] ans = new int[Long.bitCount(res)];
            for (int i = 0, j = 0; i < n; i++) {
                if (((res >> i) & 1) != 0) {
                    ans[j++] = i;
                }
            }
            return ans;
        }

        private long dfs(int i, int j) {
            if (j == 0) {
                return 0;
            }
            if (i < 0) {
                return all;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            long res = dfs(i - 1, j);
            long res2 = dfs(i - 1, j & ~mask[i]) | (1L << i);
            return memo[i][j] = Long.bitCount(res) < Long.bitCount(res2) ? res : res2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       