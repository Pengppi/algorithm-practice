/**
 * @Title: 26.删除有序数组中的重复项
 * @TitleSlug: removeDuplicatesFromSortedArray
 * @Author: Neo
 * @Date: 2023-11-25 23:38:00
 */
package leetcode.editor.cn;

public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 删除有序数组中的重复项().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 1, idx = 1, n = nums.length;
            while (i < n) {
                while (i < n && nums[i] == nums[i - 1]) {
                    i++;
                }
                if (i >= n) {
                    break;
                }
                nums[idx++] = nums[i++];
            }
            return idx;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       