/**
 * @Title: 55.跳跃游戏
 * @TitleSlug: JumpGame
 * @Author: Neo
 * @Date: 2022-11-01 14:59:46
 */
package leetcode.editor.cn;

public class 跳跃游戏 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 跳跃游戏().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int dist = 0;
            for (int i = 0; i < n; i++) {
                if (i <= dist) {
                    dist = Math.max(dist, i + nums[i]);
                    if (dist >= n - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
