/**
 * @Title: 514.自由之路
 * @TitleSlug: freedomTrail
 * @Author: Neo
 * @Date: 2024-01-29 09:28:34
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 自由之路 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 自由之路().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private char[] r, k;
        private int[][] left, right, memo;
        
        public int findRotateSteps(String ring, String key) {
            r = ring.toCharArray();
            k = key.toCharArray();
            int n = r.length, m = k.length;
            left = new int[n][26];
            right = new int[n][26];
            int[] pos = new int[26];
            for (int i = 0; i < n; i++) {
                r[i] -= 'a';
                pos[r[i]] = i;
            }
            for (int i = 0; i < n; i++) {
                System.arraycopy(pos, 0, left[i], 0, 26);
                pos[r[i]] = i;
            }
            for (int i = n - 1; i >= 0; i--) {
                pos[r[i]] = i;
            }
            for (int i = n - 1; i >= 0; i--) {
                System.arraycopy(pos, 0, right[i], 0, 26);
                pos[r[i]] = i;
            }
            memo = new int[n][m];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return key.length() + dfs(0, 0);
        }
        
        
        private int dfs(int i, int j) {
            if (j >= k.length) {
                return 0;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int t = k[j] - 'a';
            if (t == r[i]) {
                return memo[i][j] = dfs(i, j + 1);
            }
            int le = left[i][t], ri = right[i][t];
            int lRes = dfs(le, j + 1) + (le < i ? i - le : r.length - le + i);
            int rRes = dfs(ri, j + 1) + (ri > i ? ri - i : r.length - i + ri);
            return memo[i][j] = Math.min(lRes, rRes);
            
        }
        
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       