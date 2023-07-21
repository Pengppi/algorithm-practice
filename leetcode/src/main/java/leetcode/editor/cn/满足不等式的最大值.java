/**
 * @Title: 1499.满足不等式的最大值
 * @TitleSlug: maxValueOfEquation
 * @Author: Neo
 * @Date: 2023-07-21 21:42:30
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 满足不等式的最大值 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 满足不等式的最大值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxValueOfEquation(int[][] points, int k) {
            int ans = Integer.MIN_VALUE;
            Deque<int[]> d = new ArrayDeque<>();
            for (int[] p : points) {
                int x = p[0], y = p[1];
                while (!d.isEmpty() && d.peekFirst()[0] < x - k) {
                    d.pollFirst();
                }
                if (!d.isEmpty()) {
                    ans = Math.max(ans, x + y + d.peekFirst()[1]);
                }
                while (!d.isEmpty() && d.peekLast()[1] <= y - x) {
                    d.pollLast();
                }
                d.addLast(new int[]{x, y - x});
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       