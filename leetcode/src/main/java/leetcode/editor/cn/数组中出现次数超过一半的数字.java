/**
 * @Title: 剑指 Offer 39.数组中出现次数超过一半的数字
 * @TitleSlug: shuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof
 * @Author: Neo
 * @Date: 2023-05-01 15:05:38
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数组中出现次数超过一半的数字().new Solution();
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
        
       