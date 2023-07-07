/**
 * @Title: 907.子数组的最小值之和
 * @TitleSlug: SumOfSubarrayMinimums
 * @Author: Neo
 * @Date: 2022-10-28 14:41:11
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 子数组的最小值之和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 子数组的最小值之和().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            int[] l = new int[n];
            int[] r = new int[n];
            Arrays.fill(l, -1);
            Arrays.fill(r, n);
            int MOD = (int) (1e9 + 7);
            Deque<Integer> d = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!d.isEmpty() && arr[d.peekLast()] >= arr[i]) {
                    r[d.pollLast()] = i;
                }
                d.addLast(i);
            }
            d.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!d.isEmpty() && arr[d.peekLast()] > arr[i]) {
                    l[d.pollLast()] = i;
                }
                d.addLast(i);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int a = i - l[i];
                int b = r[i] - i;
                ans += 1L * a * b % MOD * arr[i] % MOD;
                ans %= MOD;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}