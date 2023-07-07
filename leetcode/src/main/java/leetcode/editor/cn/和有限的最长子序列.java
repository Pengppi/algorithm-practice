/**
 * @Title: 2389.和有限的最长子序列
 * @TitleSlug: longestSubsequenceWithLimitedSum
 * @Author: Neo
 * @Date: 2023-03-17 15:13:58
 */
package leetcode.editor.cn;

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.Arrays;

public class 和有限的最长子序列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 和有限的最长子序列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            int n = nums.length;
            int m = queries.length;
            int[] ans = new int[m];
            Arrays.sort(nums);
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = nums[i] + sum[i];
            }
            for (int i = 0; i < m; i++) {
                ans[i] = find(sum, queries[i]) - 1;
            }
            return ans;
        }

        int find(int[] sum, int t) {
            int l = 1, r = sum.length;
            while (l < r) {
                int m = l + (r - l) >> 1;
                System.out.println(l + " " + m + " " + r);
                if (sum[m] > t) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
