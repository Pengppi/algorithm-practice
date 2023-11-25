/**
 * @Title: 80.删除有序数组中的重复项 II
 * @TitleSlug: removeDuplicatesFromSortedArrayIi
 * @Author: Neo
 * @Date: 2023-11-26 00:38:41
 */
package leetcode.editor.cn;

public class 删除有序数组中的重复项II {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 删除有序数组中的重复项II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 2, j = 2;
            while (j < nums.length) {
                if (nums[j] != nums[i - 2]) {
                    nums[i++] = nums[j];
                }
                j++;
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       