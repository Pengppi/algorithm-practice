/**
 * @Author: Neo
 * @Date: 2023/12/17 星期日 10:46 上午
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pengppi
 * @date 2023/12/17
 * @url https://leetcode.cn/contest/weekly-contest-376
 */
public class WeeklyContest376 {

    /**
     * @title 100123. 执行操作使频率分数最大
     * @url https://leetcode.cn/problems/apply-operations-to-maximize-frequency-score/
     */
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = nums[i] + s[i];
        }
        int ans = 0, left = 0;
        for (int i = 0; i < n; i++) {
            while (getScore(nums, s, left, (left + i) >> 1, i) > k) {
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    private long getScore(int[] nums, long[] s, int l, int m, int r) {
        long left = (long) nums[m] * (m - l) - (s[m] - s[l]);
        long right = s[r + 1] - s[m + 1] - (long) nums[m] * (r - m);
        return left + right;
    }


    /**
     * @title 100151. 使数组成为等数数组的最小代价
     * @url https://leetcode.cn/problems/minimum-cost-to-make-array-equalindromic/
     */
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = (nums[(n - 1) >> 1] + nums[n >> 1]) >> 1;
        List<Integer> candidates = getCandidates(mid);
        long ans = -1;
        for (Integer candidate : candidates) {
            if (ans == -1)
                ans = getCost(candidate, nums);
            else
                ans = Math.min(ans, getCost(candidate, nums));
        }
        return ans;
    }

    private long getCost(int candidate, int[] nums) {
        long cost = 0;
        for (int x : nums) {
            cost += Math.abs(candidate - x);
        }
        return cost;
    }

    private List<Integer> getCandidates(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(num);
            return res;
        }
        res.add((int) Math.pow(10, n) + 1);
        res.add((int) Math.pow(10, n - 1) - 1);

        int prefix = Integer.valueOf(s.substring(0, (n + 1) / 2));
        for (int i = prefix - 1; i <= prefix + 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            StringBuilder suffix = new StringBuilder(sb).reverse();
            sb.append(suffix.substring(n & 1));
            String candidate = sb.toString();
            try {
                res.add(Integer.valueOf(candidate));
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return res;
    }


    /**
     * @title 100161. 划分数组并满足最大差限制
     * @url https://leetcode.cn/problems/divide-array-into-arrays-with-max-difference/
     */
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int len = n / 3;
        int[][] ans = new int[len + 1][3];
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                int idx = i * 3 + j;
                ans[i][j] = nums[idx];
                if (j > 0 && ans[i][j] - ans[i][j - 1] > k) {
                    return new int[][]{};
                }
                if (j > 1 && ans[i][j] - ans[i][j - 2] > k) {
                    return new int[][]{};
                }
            }
        }
        return ans;
    }

    /**
     * @title 100149.找出缺失和重复的数字
     * @url https://leetcode.cn/problems/find-missing-and-repeated-values/
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] arr = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j];
                arr[x]++;
            }
        }
        int a = -1, b = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 2) {
                a = i;
            }
            if (arr[i] == 0) {
                b = i;
            }
        }
        return new int[]{a, b};
    }
}
