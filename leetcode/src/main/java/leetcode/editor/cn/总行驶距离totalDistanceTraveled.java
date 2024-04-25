/**
 * @Title: 2739.总行驶距离
 * @TitleSlug: totalDistanceTraveled
 * @Author: Neo
 * @Date: 2024-04-25 22:43:45
 */
package leetcode.editor.cn;

public class 总行驶距离totalDistanceTraveled {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 总行驶距离totalDistanceTraveled().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distanceTraveled(int mainTank, int additionalTank) {
            int ans = 0;
            while (mainTank > 0) {
                if (mainTank >= 5 && additionalTank > 0) {
                    ans += 5;
                    mainTank -= 4;
                    additionalTank--;
                } else {
                    ans += mainTank;
                    break;
                }
            }
            return ans * 10;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       