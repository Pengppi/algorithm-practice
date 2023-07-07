/**
 * @Title: 2441.与对应负数同时存在的最大正整数
 * @TitleSlug: largestPositiveIntegerThatExistsWithItsNegative
 * @Author: Neo
 * @Date: 2023-05-13 15:42:55
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class 与对应负数同时存在的最大正整数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 与对应负数同时存在的最大正整数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxK(int[] nums) {
            int ans = -1;
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) {
                if (list.contains(-num)) {
                    ans = Math.max(ans, Math.abs(num));
                }
                list.add(num);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       