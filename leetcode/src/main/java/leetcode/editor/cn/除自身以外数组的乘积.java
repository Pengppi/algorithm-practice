/**
 * @Title: 238.除自身以外数组的乘积
 * @TitleSlug: productOfArrayExceptSelf
 * @Author: Neo
 * @Date: 2023-11-06 15:19:04
 */
package leetcode.editor.cn;

public class 除自身以外数组的乘积 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 除自身以外数组的乘积().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int ans[] = new int[n];
            int l[] = new int[n];
            int r[] = new int[n];
            l[0] = 1;
            for (int i = 1; i < n; i++) {
                l[i] = nums[i - 1] * l[i - 1];
            }
            r[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                r[i] = nums[i + 1] * r[i + 1];
            }
            for (int i = 0; i < n; i++) {
                ans[i] = l[i] * r[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       