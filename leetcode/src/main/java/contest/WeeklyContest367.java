/**
 * @Author: Neo
 * @Date: 2023/10/15 Sunday 01:28 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Pengppi
 * @date 2023/10/15
 * @url https://leetcode.cn/contest/weekly-contest-367/
 */
public class WeeklyContest367 {
    /**
     * 第一题&第三题
     *
     * @param nums
     * @param indexDifference
     * @param valueDifference
     * @return {@code int[] }
     * @date 2023/10/15
     */
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int mxId = 0, mnId = 0;
        for (int i = indexDifference; i < n; i++) {
            int j = i - indexDifference;
            if (nums[j] > nums[mxId]) {
                mxId = j;
            }
            if (nums[j] < nums[mnId]) {
                mnId = j;
            }
            if (nums[mxId] - nums[i] >= valueDifference) {
                return new int[]{mxId, i};
            }
            if (nums[i] - nums[mnId] >= valueDifference) {
                return new int[]{mnId, i};
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 第二题
     *
     * @param s
     * @param k
     * @return {@code String }
     * @date 2023/10/15
     */
    public String shortestBeautifulSubstring(String s, int k) {
        int len = s.length();
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + s.charAt(i - 1) - '0';
        }
        if (sum[len] < k) {
            return "";
        }
        if (sum[len] == k && s.charAt(0) == '1' && s.charAt(len - 1) == '1') {
            return s;
        }
        for (int i = k; i < len; i++) {
            List<String> list = new ArrayList<>();
            for (int j = i; j <= len; j++) {
                if (sum[j] - sum[j - i] == k) {
                    list.add(s.substring(j - i, j));
                }
            }
            if (!list.isEmpty()) {
                Collections.sort(list);
                return list.get(0);
            }
        }
        return "";
    }

    /**
     * 第四题
     *
     * @param grid
     * @return {@code int[][] }
     * @date 2023/10/15
     */
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n][m];
        long sum = 1;
        final int MOD = 12345;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                ans[i][j] = (int) sum;
                sum = sum * grid[i][j] % MOD;
            }
        }
        sum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = (int) (ans[i][j] * sum % MOD);
                sum = sum * grid[i][j] % MOD;
            }
        }
        return ans;
    }
}
