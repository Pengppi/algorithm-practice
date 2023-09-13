/**
 * @Title: 2596.检查骑士巡视方案
 * @TitleSlug: checkKnightTourConfiguration
 * @Author: Neo
 * @Date: 2023-09-13 14:31:10
 */
package leetcode.editor.cn;

public class 检查骑士巡视方案 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 检查骑士巡视方案().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkValidGrid(int[][] grid) {
            if(grid[0][0]!=0)
            {
                return false;
            }
            int n = grid.length;
            int[][] pos = new int[n * n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    pos[grid[i][j]][0] = i;
                    pos[grid[i][j]][1] = j;
                }
            }
            int x = 0, y = 0;
            for (int i = 1; i < n * n; i++) {
                int nx = pos[i][0], ny = pos[i][1];
                int dx = Math.abs(nx - x), dy = Math.abs(ny - y);
                if (dx * dy != 2) {
                    return false;
                }
                x = nx;
                y = ny;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       