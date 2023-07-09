/**
 * @Title: 167.两数之和 II - 输入有序数组
 * @TitleSlug: twoSumIiInputArrayIsSorted
 * @Author: Neo
 * @Date: 2023-07-08 15:36:51
 */
package leetcode.editor.cn;

public class 两数之和II输入有序数组 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 两数之和II输入有序数组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int l = 0, r = numbers.length - 1;
            while (l < r) {
                int sum = numbers[l] + numbers[r];
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return new int[]{l + 1, r + 1};
                }
            }
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       