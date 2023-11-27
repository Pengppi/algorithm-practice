/**
 * @Title: 169.多数元素
 * @TitleSlug: majorityElement
 * @Author: Neo
 * @Date: 2023-11-26 18:26:43
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 多数元素 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 多数元素().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       