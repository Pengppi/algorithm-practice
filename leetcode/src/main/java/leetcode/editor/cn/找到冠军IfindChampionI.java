/**
 * @Title: 2923.找到冠军 I
 * @TitleSlug: findChampionI
 * @Author: Neo
 * @Date: 2024-04-12 00:02:48
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 找到冠军IfindChampionI {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 找到冠军IfindChampionI().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findChampion(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                if (Arrays.stream(grid[i]).filter(x -> x == 1).sum() == grid.length - 1) {
                    return i;
                }
            }
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       