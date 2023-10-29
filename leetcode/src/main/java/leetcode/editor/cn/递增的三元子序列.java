/**
 * @Title: 334.递增的三元子序列
 * @TitleSlug: increasingTripletSubsequence
 * @Author: Neo
 * @Date: 2023-10-29 23:57:09
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 递增的三元子序列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 递增的三元子序列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int n = nums.length;
            int mn = nums[0], mx = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                if (nums[i] > mx) {
                    return true;
                } else if (nums[i] > mn) {
                    mx = nums[i];
                } else {
                    mn = nums[i];
                }
            }
            return false;
        }

        private boolean func1(int[] nums) {
            Deque<Integer> d = new ArrayDeque<>();
            for (int num : nums) {
                while (!d.isEmpty() && d.peekLast() >= num) {
                    d.pollLast();
                }
                d.addLast(num);
                if (d.size() == 3) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       