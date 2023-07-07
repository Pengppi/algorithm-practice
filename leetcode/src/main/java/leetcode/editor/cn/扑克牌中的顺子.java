/**
 * @Title: 剑指 Offer 61.扑克牌中的顺子
 * @TitleSlug: buKePaiZhongDeShunZiLcof
 * @Author: Neo
 * @Date: 2023-05-30 13:19:12
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 扑克牌中的顺子 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 扑克牌中的顺子().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            int joker = 0;
            Arrays.sort(nums);
            for (int i = 0; i < 4; i++) {
                if (nums[i] == 0) {
                    joker++;
                } else if (nums[i] == nums[i + 1]) {
                    return false;
                }
            }
            return nums[4] - nums[joker] < 5;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       