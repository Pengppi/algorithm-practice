/**
 * @Title: 1222.可以攻击国王的皇后
 * @TitleSlug: queensThatCanAttackTheKing
 * @Author: Neo
 * @Date: 2023-09-14 15:50:44
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 可以攻击国王的皇后 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 可以攻击国王的皇后().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int x;
        int y;
        List<List<Integer>> ans;

        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            int[][] mat = new int[8][8];
            x = king[0];
            y = king[1];
            ans=new ArrayList<>();
            for (int[] q : queens) {
                mat[q[0]][q[1]] = 1;
            }
            int[][] dir = new int[][]{{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};
            for (int[] d : dir) {
                dfs(mat, d[0], d[1]);
            }
            return ans;
        }

        private void dfs(int[][] mat, int i, int j) {
            int nx = x + i, ny = y + j;
            while (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                if (mat[nx][ny] == 1) {
                    ans.add(Arrays.asList(new Integer[]{nx, ny}));
                    return;
                }
                nx += i;
                ny += j;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       