/**
 * @Title: 215.数组中的第K个最大元素
 * @TitleSlug: kthLargestElementInAnArray
 * @Author: Neo
 * @Date: 2023-10-21 17:28:23
 */
package leetcode.editor.cn;

public class 数组中的第K个最大元素 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数组中的第K个最大元素().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            return quickSelect(nums, 0, n - 1, n - k);
        }

        private int quickSelect(int[] nums, int l, int r, int k) {
            if (l == r) {
                return nums[k];
            }
            int x = nums[l], i = l - 1, j = r + 1;
            while (i < j) {
                while (nums[++i] < x) ;
                while (nums[--j] > x) ;
                if (i < j) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
            if (k <= j) return quickSelect(nums, l, j, k);
            else return quickSelect(nums, j+1, r, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       