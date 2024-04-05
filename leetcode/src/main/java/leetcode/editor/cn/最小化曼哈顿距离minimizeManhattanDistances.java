/**
 * @Title: 3102.最小化曼哈顿距离
 * @TitleSlug: minimizeManhattanDistances
 * @Author: Neo
 * @Date: 2024-04-05 19:22:56
 */
package leetcode.editor.cn;

public class 最小化曼哈顿距离minimizeManhattanDistances {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最小化曼哈顿距离minimizeManhattanDistances().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDistance(int[][] points) {
            final int inf = Integer.MAX_VALUE;
            int[] maxX = new int[]{-inf, -inf}, maxY = new int[]{-inf, -inf};
            int[] minX = new int[]{inf, inf}, minY = new int[]{inf, inf};
            for (int[] p : points) {
                int x = p[0] + p[1];
                int y = p[1] - p[0];
                compareMax(maxX, x);
                compareMax(maxY, y);
                compareMin(minX, x);
                compareMin(minY, y);
            }
            int ans = inf;
            for (int[] p : points) {
                int x = p[0] + p[1], y = p[1] - p[0];
                int dx = (x == maxX[0] ? maxX[1] : maxX[0]) - (x == minX[0] ? minX[1] : minX[0]);
                int dy = (y == maxY[0] ? maxY[1] : maxY[0]) - (y == minY[0] ? minY[1] : minY[0]);
                ans = Math.min(ans, Math.max(dx, dy));
            }
            return ans;
        }
        
        private void compareMax(int[] max, int i) {
            if (i > max[0]) {
                max[1] = max[0];
                max[0] = i;
            } else if (i > max[1]) {
                max[1] = i;
            }
        }
        
        private void compareMin(int[] min, int i) {
            if (i < min[0]) {
                min[1] = min[0];
                min[0] = i;
            } else if (i < min[1]) {
                min[1] = i;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       