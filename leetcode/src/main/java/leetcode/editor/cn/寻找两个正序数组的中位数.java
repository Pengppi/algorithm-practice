/**
 * @Title: 4.寻找两个正序数组的中位数
 * @TitleSlug: medianOfTwoSortedArrays
 * @Author: Neo
 * @Date: 2023-12-07 12:01:22
 */
package leetcode.editor.cn;

public class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 寻找两个正序数组的中位数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int k1 = (n + m + 1) / 2;
            int k2 = (n + m + 2) / 2;
            return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, k1)
                    + getKth(nums1, 0, m - 1, nums2, 0, n - 1, k2)) * 0.5;
        }

        private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            if (len1 > len2) {
                return getKth(nums2, start2, end2, nums1, start1, end1, k);
            }
            if (len1 == 0) {
                return nums2[start2 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }
            int i = start1 + Math.min(k / 2, len1) - 1;
            int j = start2 + Math.min(k / 2, len2) - 1;
            if (nums1[i] < nums2[j]) {
                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
            } else {
                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       