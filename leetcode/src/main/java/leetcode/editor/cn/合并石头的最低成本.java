/**
 * @Title: 1000.合并石头的最低成本
 * @TitleSlug: minimumCostToMergeStones
 * @Author: Neo
 * @Date: 2023-04-04 22:35:41
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class 合并石头的最低成本 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 合并石头的最低成本().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][][] memo;
    int[] s;
    int k;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        memo = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        this.k = k;
        s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + stones[i];
        }
        return dfs(0, n-1, 1);

    }

    public int dfs(int i, int j, int p) {
        if (memo[i][j][p] != -1) {
            return memo[i][j][p];
        }
        if (p == 1) {
            memo[i][j][p] = i == j ? 0 : dfs(i, j, k) + s[j + 1] - s[i];
            return memo[i][j][p];
        }
        int res = Integer.MAX_VALUE;
        for (int m = i; m < j; m += k - 1) {
            res = Math.min(res, dfs(i, m, 1) + dfs(m + 1, j, p - 1));
        }
        memo[i][j][p]=res;
        return memo[i][j][p];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
