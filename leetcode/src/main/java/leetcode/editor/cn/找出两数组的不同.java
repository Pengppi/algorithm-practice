/**
 * @Title: 2215.找出两数组的不同
 * @TitleSlug: findTheDifferenceOfTwoArrays
 * @Author: Neo
 * @Date: 2023-10-20 23:37:22
 */
package leetcode.editor.cn;

import java.util.*;

public class 找出两数组的不同 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 找出两数组的不同().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            ans.add(l1);
            ans.add(l2);
            Set<Integer> st1 = new HashSet<>();
            Set<Integer> st2 = new HashSet<>();
            for (int i : nums1) {
                st1.add(i);
            }
            for (int i : nums2) {
                st2.add(i);
            }
            for (int i : st1) {
                if (!st2.contains(i)) {
                    l1.add(i);
                }
            }
            for (int i : st2) {
                if (!st1.contains(i)) {
                    l2.add(i);
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       