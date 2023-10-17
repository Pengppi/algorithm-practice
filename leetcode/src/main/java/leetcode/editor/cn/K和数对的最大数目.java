/**
 * @Title: 1679.K 和数对的最大数目
 * @TitleSlug: maxNumberOfKSumPairs
 * @Author: Neo
 * @Date: 2023-10-17 14:28:00
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class K和数对的最大数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new K和数对的最大数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxOperations(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length, ans = 0;
            int l = 0, r = n - 1;
            while (l < r) {
                int t = nums[l] + nums[r];
                if (t < k) {
                    l++;
                } else if (t > k) {
                    r--;
                } else {
                    l++;
                    r--;
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       