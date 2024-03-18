/**
 * @Title: LCR 037.行星碰撞
 * @TitleSlug: XagZNi
 * @Author: Neo
 * @Date: 2024-03-16 19:14:21
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 行星碰撞XagZNi {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 行星碰撞XagZNi().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new ArrayDeque<>();
            List<Integer> ans = new ArrayList<>();
            for (int a : asteroids) {
                if (a > 0) {
                    stack.addLast(a);
                } else if (stack.isEmpty()) {
                    ans.add(a);
                } else {
                    int fir = stack.peekFirst();
                    while (!stack.isEmpty() && stack.peekLast() <= -a) {
                        if (stack.pollLast() == -a) {
                            break;
                        }
                    }
                    if (stack.isEmpty() && fir < -a) {
                        ans.add(a);
                    }
                }
            }
            stack.stream().forEach(ans::add);
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
       