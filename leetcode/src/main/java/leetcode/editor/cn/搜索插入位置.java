/**
 * @Title: 35.搜索插入位置
 * @TitleSlug: searchInsertPosition
 * @Author: Neo
 * @Date: 2023-12-14 01:10:15
 */
package leetcode.editor.cn;

public class 搜索插入位置 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 搜索插入位置().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = -1, r = nums.length;
            while (l + 1 < r) {
                int m = l + (r - l) / 2;
                if (nums[m] < target) {
                    l = m;
                } else {
                    r = m;
                }
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       