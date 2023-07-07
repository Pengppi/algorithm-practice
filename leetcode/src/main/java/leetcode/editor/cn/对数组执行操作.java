/**
 * @Title: 2460.对数组执行操作
 * @TitleSlug: applyOperationsToAnArray
 * @Author: Neo
 * @Date: 2023-06-05 14:49:16
 */
package leetcode.editor.cn;

public class 对数组执行操作 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 对数组执行操作().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] applyOperations(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] = nums[i] * 2;
                    nums[i + 1] = 0;
                }
            }
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    ans[index++] = nums[i];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       