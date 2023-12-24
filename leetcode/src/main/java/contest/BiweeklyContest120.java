/**
 * @Author: Neo
 * @Date: 2023/12/23 星期六 10:33 下午
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BiweeklyContest120 {
    class Solution {

        /**
         * @title 100171. 统计移除递增子数组的数目 I
         * @url https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-i/
         */
        public int incremovableSubarrayCount(int[] nums) {
            int n = nums.length;
            int i = 0;
            while (i < n - 1 && nums[i] < nums[i + 1]) {
                i++;
            }
            if (i == n - 1) {
                return n * (n + 1) / 2;
            }
            int ans = i + 2;
            for (int j = n - 1; j > 0 && (j == n - 1 || nums[j + 1] > nums[j]); j--) {
                while (i >= 0 && nums[i] >= nums[j]) {
                    i--;
                }
                ans += i + 2;
            }
            return ans;
        }


        /**
         * @title 100180. 找到最大周长的多边形
         * @url https://leetcode.cn/problems/find-polygon-with-the-largest-perimeter/
         */
        public long largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            long[] sum = new long[n + 1];
            long ans = -1;
            for (int i = 0; i < n; i++) {
                sum[i + 1] = nums[i] + sum[i];
                if (i >= 2 && nums[i] < sum[i]) {
                    ans = sum[i + 1];
                }
            }
            return ans;
        }

        /**
         * @title 10033. 统计移除递增子数组的数目 II
         * @url https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-ii/description/
         */
        public long incremovableSubarrayCount2(int[] nums) {
            int n = nums.length, i = 0;
            while (i < n - 1 && nums[i] < nums[i + 1]) {
                i++;
            }
            if (i == n - 1) {
                return (long) n * (n + 1) / 2;
            }
            long ans = i + 2;
            for (int j = n - 1; j > 0 && (j == n - 1 || nums[j] < nums[j + 1]); j--) {
                while (i >= 0 && nums[i] >= nums[j]) {
                    i--;
                }
                ans += i + 2;
            }
            return ans;
        }

        /**
         * @title 10033. 统计移除递增子数组的数目 II
         * @url https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-ii/description/
         */
        public long[] placedCoins(int[][] edges, int[] cost) {
            int n = cost.length;
            List<Integer>[] g = new List[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int[] e : edges) {
                g[e[0]].add(e[1]);
                g[e[1]].add(e[0]);
            }
            long[] ans = new long[n];
            dfs(ans, cost, g, 0, -1);
            return ans;
        }

        private List<Integer> dfs(long[] ans, int[] cost, List<Integer>[] g, int x, int fa) {
            List<Integer> a = new ArrayList<>();
            a.add(cost[x]);
            for (Integer y : g[x]) {
                if (y != fa) {
                    a.addAll(dfs(ans, cost, g, y, x));
                }
            }
            Collections.sort(a);
            int n = a.size();
            if (n < 3) {
                ans[x] = 1;
            } else {
                ans[x] = Math.max(0, Math.max(
                        (long) a.get(n - 1) * a.get(n - 2) * a.get(n - 3),
                        (long) a.get(n - 1) * a.get(0) * a.get(1)));
            }
            if (n > 5) {
                a = Arrays.asList(new Integer[]{a.get(0), a.get(1), a.get(n - 3), a.get(n - 2), a.get(n - 1)});
            }
            return a;
        }


    }
}
