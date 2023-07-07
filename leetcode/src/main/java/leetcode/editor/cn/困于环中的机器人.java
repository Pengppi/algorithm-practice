/**
 * @Title: 1041.困于环中的机器人
 * @TitleSlug: robotBoundedInCircle
 * @Author: Neo
 * @Date: 2023-04-11 10:25:01
 */
package leetcode.editor.cn;

public class 困于环中的机器人 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 困于环中的机器人().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isRobotBounded(String instructions) {
            int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int x = 0, y = 0, di = 0;
            for (char c : instructions.toCharArray()) {
                if (c == 'G') {
                    x += dir[di][0];
                    y += dir[di][1];
                } else if (c == 'L') {
                    di = di + 3;
                    di %= 4;
                } else {
                    di = di + 1;
                    di %= 4;
                }
            }
            return (x == 0 && y == 0) || di != 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
