/**
 * @Title: 2216.美化数组的最少删除数
 * @TitleSlug: minimumDeletionsToMakeArrayBeautiful
 * @Author: Neo
 * @Date: 2023-11-21 00:12:14
 */
package leetcode.editor.cn;

public class 美化数组的最少删除数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 美化数组的最少删除数().new Solution();
        solution.minDeletion(new int[]{2, 8, 1, 0, 4, 4, 7, 0, 4, 5, 1, 2, 4, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDeletion(int[] nums) {
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n; i += 2) {
                int j = i + 1;
                while (j < n && nums[i] == nums[j]) {
                    j++;
                    ans++;
                }
                i = j - 1;
            }
            if ((n - ans) % 2 == 0) {
                return ans;
            }
            return ans + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       