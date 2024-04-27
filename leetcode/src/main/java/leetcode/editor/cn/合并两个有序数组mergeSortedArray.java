/**
 * @Title: 88.合并两个有序数组
 * @TitleSlug: mergeSortedArray
 * @Author: Neo
 * @Date: 2024-04-27 23:51:20
 */
package leetcode.editor.cn;

public class 合并两个有序数组mergeSortedArray {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 合并两个有序数组mergeSortedArray().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int cur = m + n - 1, i = m - 1, j = n - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[cur--] = nums1[i--];
                } else {
                    nums1[cur--] = nums2[j--];
                }
            }
            if (j >= 0) {
                System.arraycopy(nums2, 0, nums1, 0, j + 1);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       