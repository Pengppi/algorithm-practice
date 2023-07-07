/**
 * @Title: LCP 28.采购方案
 * @TitleSlug: fourXy4Wx
 * @Author: Neo
 * @Date: 2023-04-30 14:42:46
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 采购方案 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 采购方案().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int purchasePlans(int[] nums, int target) {
            Arrays.sort(nums);
            int mod = 1000000007;
            int cnt = 0;
            int n = nums.length;
            //for (int i = 1; i < n; i++) {
            //    if (nums[i] > target)
            //        break;
            //    int t = target - nums[i];
            //    cnt = (cnt + lower_bound(nums, t + 1, i) - 1 + 1) % mod;
            //}
            int l = 0, r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    cnt += r - l;
                    cnt %= mod;
                    l++;
                }
            }
            return cnt;
        }

        public int lower_bound(int[] nums, int t, int r) {
            int l = -1;
            while (l + 1 < r) {
                int m = l + (r - l) / 2;
                if (nums[m] < t) {
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
        
       