/**
 * @Author: Neo
 * @Date: 2024/04/27 Saturday 22:30
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.HashMap;

public class BiweeklyContest129 {
    final int mod = (int) 1e9 + 7;
    final HashMap<String, Integer> memo = new HashMap<>();
    
    public int numberOfStableArrays(int zero, int one, int limit) {
        return (dfs(zero - 1, one, limit, false, 1) + dfs(zero, one - 1, limit, true, 1)) % mod;
    }
    
    private int dfs(int zero, int one, int limit, boolean flg, int len) {
        if (len > limit) {
            return 0;
        }
        if (zero == 0 && one == 0) {
            return 1;
        }
        String key = zero + "#" + one + "#" + flg + "#" + len;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = 0;
        if (zero > 0) {
            res = (res + dfs(zero - 1, one, limit, false, !flg ? len + 1 : 1)) % mod;
        }
        if (one > 0) {
            res = (res + dfs(zero, one - 1, limit, true, flg ? len + 1 : 1)) % mod;
        }
        memo.put(key, res);
        return res;
    }
    
    
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m], col = new int[n];
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && row[i] > 1 && col[j] > 1) {
                    ans += (long) (row[i] - 1) * (col[j] - 1);
                }
            }
        }
        return ans;
    }
    
    
    public boolean canMakeSquare(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + 1, y = j + 1;
                preSum[x][y] = preSum[i][y] + preSum[x][j] - preSum[i][j] + (grid[i][j] == 'W' ? 1 : -1);
                if (x >= 2 && y >= 2) {
                    int sum = Math.abs(preSum[x][y] - preSum[x - 2][y] - preSum[x][y - 2] + preSum[x - 2][y - 2]);
                    if (sum != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
