/**
 * @Title: 1.两数之和 
 * @TitleSlug: TwoSum
 * @Author: Neo
 * @Date: 2022-10-18 23:01:50
 */
package leetcode.editor.cn;
public class 两数之和{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 两数之和().new Solution();
    }
      
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
