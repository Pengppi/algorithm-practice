/**
 * @Title: 27.移除元素
 * @TitleSlug: removeElement
 * @Author: Neo
 * @Date: 2023-11-24 00:36:32
 */
package leetcode.editor.cn;

public class 移除元素 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 移除元素().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            int idx = 0, n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] != val) {
                    nums[idx++] = nums[i];
                }
            }
            return idx;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       