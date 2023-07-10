/**
 * @Title: 16.最接近的三数之和
 * @TitleSlug: threeSumClosest
 * @Author: Neo
 * @Date: 2023-07-10 17:11:24
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 最接近的三数之和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最接近的三数之和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);
            int ans = Integer.MAX_VALUE, diff = Integer.MAX_VALUE;
            for (int i = 0; i < n - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1, r = n - 1;
                while (l < r) {
                    int s = nums[i] + nums[l] + nums[r];
                    if (s < target) {
                        while (l < r && nums[l] == nums[++l]) ;
                    } else {
                        while (l < r && nums[r] == nums[--r]) ;
                    }
                    int cur = Math.abs(s - target);
                    if (cur < diff) {
                        diff = cur;
                        ans = s;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       