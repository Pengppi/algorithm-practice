/**
 * @Author: Neo
 * @Date: 2024/04/07 Sunday 10:39
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.Arrays;

public class WeeklyContest392 {
    
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[][] f = new int[n][n];
        int inf = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], inf);
            f[i][i] = 0;
        }
        for (int[] e : edges) {
            int x = e[0], y = e[1], w = e[2];
            f[x][y] = f[y][x] = w;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (f[i][k] == inf) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (f[k][j] == inf) {
                        continue;
                    }
                    int dist = f[i][j];
                    if (f[k][j] == 0) {
                        f[i][j] = Math.min(f[i][j], f[k][j]);
                    } else if (f[i][k] == 0) {
                        f[i][j] = Math.min(f[i][j], f[k][j]);
                    } else {
                        f[i][j] = Math.min(f[i][j], f[i][k] & f[k][j]);
                    }
                    f[i][j] = Math.min(f[i][j] & dist, f[i][j]);
                }
            }
        }
        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int x = query[i][0], y = query[i][1];
            ans[i] = f[x][y] == inf ? -1 : f[x][y];
        }
        return ans;
    }
    
    
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long ans = 0;
        Arrays.sort(nums);
        int n = nums.length, idx;
        if ((n % 2) == 1) {
            idx = n / 2;
            
        } else {
            int l = (n - 1) / 2, r = n / 2;
            idx = nums[l] > nums[r] ? l : r;
        }
        if (nums[idx] == k) {
            return 0;
        }
        ans += Math.abs(nums[idx] - k);
        nums[idx] = k;
        int i = idx - 1, j = idx + 1;
        while (i >= 0 && nums[i] > nums[i + 1]) {
            ans += nums[i] - nums[i + 1];
            nums[i] = nums[i + 1];
            i--;
        }
        while (j < n && nums[j] < nums[j - 1]) {
            ans += nums[j - 1] - nums[j];
            nums[j] = nums[j - 1];
            j++;
        }
        return ans;
    }
    
    public String getSmallestString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (k == 0) {
                sb.append(c);
                continue;
            }
            int g1 = c - 'a';
            int g2 = 'z' - c + 1;
            int gap = Math.min(g1, g2);
            if (gap <= k) {
                sb.append('a');
                k -= gap;
            } else {
                sb.append((char) (c - k));
                k = 0;
            }
        }
        return sb.toString();
    }
    
    
    public int longestMonotonicSubarray(int[] nums) {
        int len1 = 1, len2 = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len1++;
            } else {
                len1 = 1;
            }
            if (nums[i] < nums[i - 1]) {
                len2++;
            } else {
                len2 = 1;
            }
            ans = Math.max(ans, Math.max(len1, len2));
        }
        return ans;
    }
}
