/**
 * @Title: 剑指 Offer 45.把数组排成最小的数
 * @TitleSlug: baShuZuPaiChengZuiXiaoDeShuLcof
 * @Author: Neo
 * @Date: 2023-06-12 20:49:20
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 把数组排成最小的数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 把数组排成最小的数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
            StringBuilder res = new StringBuilder();
            for (String s : strs) {
                res.append(s);
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       