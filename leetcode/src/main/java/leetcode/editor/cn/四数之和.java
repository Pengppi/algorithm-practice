/**
 * @Title: 18.四数之和
 * @TitleSlug: fourSum
 * @Author: Neo
 * @Date: 2023-07-15 19:42:18
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 四数之和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            if (n < 4) {
                return ans;
            }
            Arrays.sort(nums);
            for (int a = 0; a < n - 3; a++) {
                if (a > 0 && nums[a] == nums[a - 1]) {
                    continue;
                }
                long t1 = nums[a];
                if (t1 + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                    break;
                }
                if (t1 + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                    continue;
                }
                for (int b = a + 1; b < n - 2; b++) {
                    if (b > a + 1 && nums[b] == nums[b - 1]) {
                        continue;
                    }
                    long t2 = nums[b];
                    if (t1 + t2 + nums[b + 1] + nums[b + 2] > target) {
                        break;
                    }
                    if (t1 + t2 + nums[n - 1] + nums[n - 2] < target) {
                        continue;
                    }
                    int c = b + 1, d = n - 1;
                    while (c < d) {
                        long sum = t1 + t2 + nums[c] + nums[d];
                        if (sum > target) {
                            while (c < d && nums[d] == nums[--d]) ;
                        } else if (sum < target) {
                            while (c < d && nums[c] == nums[++c]) ;
                        } else {
                            ans.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                            while (c < d && nums[d] == nums[--d]) ;
                            while (c < d && nums[c] == nums[++c]) ;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       