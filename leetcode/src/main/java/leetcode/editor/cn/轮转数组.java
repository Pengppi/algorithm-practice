/**
 * @Title: 189.轮转数组
 * @TitleSlug: rotateArray
 * @Author: Neo
 * @Date: 2023-11-26 18:27:22
 */
package leetcode.editor.cn;

public class 轮转数组 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 轮转数组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            int[] tmp = new int[k];
            for (int i = n - 1; i >= 0; i--) {
                if (i >= n - k) {
                    tmp[i - (n - k)] = nums[i];
                } else {
                    nums[i + k] = nums[i];
                }
                if (i < k) {
                    nums[i] = tmp[i];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       