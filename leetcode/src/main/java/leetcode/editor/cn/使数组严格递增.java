/**
 * @Title: 1187.使数组严格递增
 * @TitleSlug: makeArrayStrictlyIncreasing
 * @Author: Neo
 * @Date: 2023-04-20 00:50:37
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 使数组严格递增 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 使数组严格递增().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> memo[];
        int[] a, b;

        public int makeArrayIncreasing(int[] arr1, int[] arr2) {
            int n = arr1.length;
            Arrays.sort(arr2);
            memo = new HashMap[n];
            int m = 0;
            for (int x : arr2) {
                if (m == 0 || x != arr2[m - 1]) {
                    arr2[m++] = x;
                }
            }
            a = arr1;
            b = Arrays.copyOf(arr2, m);
            Arrays.setAll(memo, i -> new HashMap<>());
            int ans = dfs(n - 1, Integer.MAX_VALUE);
            return ans < Integer.MAX_VALUE / 2 ? ans : -1;
        }

        private int dfs(int i, int pre) {
            if (i < 0) {
                return 0;
            }
            if (memo[i].containsKey(pre)) {
                return memo[i].get(pre);
            }
            int ans = a[i] < pre ? dfs(i - 1, a[i]) : Integer.MAX_VALUE / 2;
            int k = lowerBound(b, pre) - 1;
            if (k >= 0) {
                ans = Math.min(ans, dfs(i - 1, b[k]) + 1);
            }
            memo[i].put(pre, ans);
            return ans;
        }

        private int lowerBound(int[] nums, int target) {
            int l = -1, r = nums.length;
            while (l + 1 < r) {
                int m = (l + r) >> 1;
                if (nums[m] < target) {
                    l = m;
                } else {
                    r = m;
                }
            }
            return r;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       