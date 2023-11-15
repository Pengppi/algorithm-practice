/**
 * @Title: 2656.K 个元素的最大和
 * @TitleSlug: maximumSumWithExactlyKElements
 * @Author: Neo
 * @Date: 2023-11-15 14:34:32
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class K个元素的最大和 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new K个元素的最大和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximizeSum(int[] nums, int k) {
            int mx = Arrays.stream(nums).max().getAsInt();
            return mx * k + k * (k - 1) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       