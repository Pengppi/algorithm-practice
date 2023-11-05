/**
 * @Title: 162.寻找峰值
 * @TitleSlug: findPeakElement
 * @Author: Neo
 * @Date: 2023-11-05 17:49:50
 */
package leetcode.editor.cn;

public class 寻找峰值 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 寻找峰值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            int ans = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[ans]) {
                    ans = i;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       