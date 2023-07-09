/**
 * @Title: 15.三数之和
 * @TitleSlug: threeSum
 * @Author: Neo
 * @Date: 2023-07-09 10:15:34
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 三数之和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            int n = nums.length;
            Arrays.sort(nums);
            for (int k = 0; k < n - 2; k++) {
                if (nums[k] > 0) {
                    break;
                }
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                int i = k + 1, j = n - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];
                    if (sum < 0) {
                        while (i < j && nums[i] == nums[++i]);
                    } else if (sum > 0) {
                        while (i < j && nums[j] == nums[--j]);
                    } else {
                        list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        while (i < j && nums[i] == nums[++i]);
                        while (i < j && nums[j] == nums[--j]);
                    }
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       