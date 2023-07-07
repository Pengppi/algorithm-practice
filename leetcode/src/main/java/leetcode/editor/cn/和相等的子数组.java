/**
 * @Title: 2395.和相等的子数组
 * @TitleSlug: findSubarraysWithEqualSum
 * @Author: Neo
 * @Date: 2023-03-26 16:15:55
 */
package leetcode.editor.cn;

public class 和相等的子数组 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 和相等的子数组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findSubarrays(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < nums.length; i++) {
                if (!set.add(nums[i] + nums[i - 1])) {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
