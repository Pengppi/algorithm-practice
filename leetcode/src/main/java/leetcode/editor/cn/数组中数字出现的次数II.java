/**
 * @Title: 剑指 Offer 56 - II.数组中数字出现的次数 II
 * @TitleSlug: shuZuZhongShuZiChuXianDeCiShuIiLcof
 * @Author: Neo
 * @Date: 2023-05-30 10:57:25
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 数组中数字出现的次数II {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数组中数字出现的次数II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            int n=nums.length;
            for (int i = 0; i < n-1; i++) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
                i += 2;
            }
            return nums[n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       