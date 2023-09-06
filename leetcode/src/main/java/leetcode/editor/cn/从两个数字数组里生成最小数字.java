/**
 * @Title: 2605.从两个数字数组里生成最小数字
 * @TitleSlug: formSmallestNumberFromTwoDigitArrays
 * @Author: Neo
 * @Date: 2023-09-05 00:20:28
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 从两个数字数组里生成最小数字 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 从两个数字数组里生成最小数字().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minNumber(int[] nums1, int[] nums2) {
            int mn = 10;
            Set<Integer> st = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                mn = Math.min(mn, nums1[i]);
                st.add(nums1[i]);
            }
            Arrays.sort(nums2);
            for (int i = 0; i < nums2.length; i++) {
                if (st.contains(nums2[i])) {
                    return nums2[i];
                }
            }
            int mx = Math.max(mn, nums2[0]);
            mn = Math.min(mn, nums2[0]);
            return mn * 10 + mx;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       