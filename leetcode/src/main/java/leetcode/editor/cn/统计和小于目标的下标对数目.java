/**
 * @Title: 2824.统计和小于目标的下标对数目
 * @TitleSlug: countPairsWhoseSumIsLessThanTarget
 * @Author: Neo
 * @Date: 2023-11-24 00:30:34
 */
package leetcode.editor.cn;

import java.util.Collections;
import java.util.List;

public class 统计和小于目标的下标对数目 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 统计和小于目标的下标对数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPairs(List<Integer> nums, int target) {
            int ans = 0;
            Collections.sort(nums);
            int n = nums.size(), l = 0, r = n - 1;
            while (l < r) {
                int sum = nums.get(l) + nums.get(r);
                if (sum < target) {
                    ans += r - l;
                    l++;
                } else {
                    r--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       