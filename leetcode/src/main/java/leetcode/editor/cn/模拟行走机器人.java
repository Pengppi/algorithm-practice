/**
 * @Title: 874.模拟行走机器人
 * @TitleSlug: walkingRobotSimulation
 * @Author: Neo
 * @Date: 2023-07-19 18:20:58
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 模拟行走机器人 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 模拟行走机器人().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int[] dir = new int[]{0, 1, 0, -1, 0};
            int k = 0;
            Set<Integer> set = new HashSet<>();
            for (int[] obs : obstacles) {
                set.add(hash(obs[0], obs[1]));
            }
            int x = 0, y = 0, ans = 0;
            for (int c : commands) {
                if (c == -2) {
                    k = (k + 3) % 4;
                } else if (c == -1) {
                    k = (k + 1) % 4;
                } else {
                    for (int i = 0; i < c; i++) {
                        int tx = x + dir[k], ty = y + dir[k + 1];
                        if (set.contains(hash(tx, ty))) {
                            break;
                        }
                        x = tx;
                        y = ty;
                        ans= Math.max(ans,x*x+y*y);
                    }
                }
            }
            return ans;
        }

        private Integer hash(int x, int y) {
            return x * 50005 + y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       