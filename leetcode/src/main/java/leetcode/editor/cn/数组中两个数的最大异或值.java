/**
 * @Title: 421.数组中两个数的最大异或值
 * @TitleSlug: maximumXorOfTwoNumbersInAnArray
 * @Author: Neo
 * @Date: 2023-11-04 00:36:49
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

public class 数组中两个数的最大异或值 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 数组中两个数的最大异或值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaximumXOR(int[] nums) {
            int mx = Arrays.stream(nums).max().getAsInt();
            int highest = 31 - Integer.numberOfLeadingZeros(mx);
            int ans = 0, mask = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int i = highest; i >= 0; i--) {
                set.clear();
                mask |= 1 << i;
                int newAns = ans | (1 << i);
                for (int x : nums) {
                    x &= mask;
                    if (set.contains(newAns ^ x)) {
                        ans = newAns;
                        break;
                    }
                    set.add(x);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       