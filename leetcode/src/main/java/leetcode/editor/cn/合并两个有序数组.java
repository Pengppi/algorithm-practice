/**
 * @Title: 88.合并两个有序数组
 * @TitleSlug: mergeSortedArray
 * @Author: Neo
 * @Date: 2023-11-23 00:49:52
 */
package leetcode.editor.cn;

public class 合并两个有序数组 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 合并两个有序数组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int pos1 = m - 1;
            int pos2 = n - 1;
            int tail = m + n - 1;
            int cur;
            while (pos1 >= 0 || pos2 >= 0) {
                if (pos1 == -1) {
                    cur = nums2[pos2--];
                } else if (pos2 == -1) {
                    cur = nums1[pos1--];
                } else if (nums1[pos1] > nums2[pos2]) {
                    cur = nums1[pos1--];
                } else {
                    cur = nums2[pos2--];
                }
                nums1[tail--] = cur;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       