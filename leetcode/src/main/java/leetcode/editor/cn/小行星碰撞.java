/**
 * @Title: 735.小行星碰撞
 * @TitleSlug: asteroidCollision
 * @Author: Neo
 * @Date: 2023-10-11 00:26:33
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 小行星碰撞 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 小行星碰撞().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int x : asteroids) {
                boolean alive = true;
                while (alive && !stack.isEmpty() && x < 0 && stack.peek() > 0) {
                    alive = -x > stack.peek();
                    if (-x >= stack.peek()) {
                        stack.pop();
                    }
                }
                if (alive) {
                    stack.push(x);
                }
            }
            int[] ans = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       