/**
 * @Title: 902.最大为 N 的数字组合
 * @TitleSlug: NumbersAtMostNGivenDigitSet
 * @Author: Neo
 * @Date: 2022-10-18 11:27:31
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 最大为N的数字组合 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最大为N的数字组合().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int nums[];


        public int atMostNGivenDigitSet(String[] digits, int n) {
            nums = new int[digits.length];
            for (int i = 0; i < digits.length; i++) {
                nums[i] = Integer.parseInt(digits[i]);
            }
            return dp(n);
        }

        private int dp(int mx) {
            List<Integer> list = new ArrayList<>();
            while (mx > 0) {
                list.add(mx % 10);
                mx /= 10;
            }
            int n = list.size(), m = nums.length;
            int ans = 0;
            for (int i = 1; i < n; i++) {
                ans += Math.pow(m, i);
            }
            for (int i = n - 1, p = 1; i >= 0; i--, p++) {
                int cur = list.get(i);
                int l = 0, r = m - 1;
                while (l <r) {
                    int mid = (l + r + 1) >> 1;
                    if (nums[mid] <= cur) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                if (nums[r] > cur) {
                    break;
                } else if (nums[r] == cur) {
                    if (i == 0) {
                        ans++;
                    }
                    ans += r * Math.pow(m, n - p);
                } else {
                    ans += (r + 1) * Math.pow(m, n - p);
                    break;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
