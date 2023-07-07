/**
 * @Title: 34.在排序数组中查找元素的第一个和最后一个位置
 * @TitleSlug: findFirstAndLastPositionOfElementInSortedArray
 * @Author: Neo
 * @Date: 2023-04-20 12:50:06
 */
package leetcode.editor.cn;

import java.util.concurrent.locks.ReentrantLock;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 在排序数组中查找元素的第一个和最后一个位置().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int l = lowerBound(nums, target);
            if (l == nums.length || nums[l] != target) {
                return new int[]{-1, -1};
            }
            int r = lowerBound(nums, target + 1) - 1;
            return new int[]{l, r};
        }

        private int lowerBound(int[] nums, int t) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (nums[m] < t) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return l;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       