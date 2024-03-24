/**
 * @Title: 153.寻找旋转排序数组中的最小值
 * @TitleSlug: findMinimumInRotatedSortedArray
 * @Author: Neo
 * @Date: 2024-03-24 17:03:49
 */
package leetcode.editor.cn;

public class 寻找旋转排序数组中的最小值findMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 寻找旋转排序数组中的最小值findMinimumInRotatedSortedArray().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return nums[left];
            
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       