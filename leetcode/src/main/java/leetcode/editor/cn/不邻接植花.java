/**
 * @Title: 1042.不邻接植花
 * @TitleSlug: flowerPlantingWithNoAdjacent
 * @Author: Neo
 * @Date: 2023-04-15 10:51:18
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 不邻接植花 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 不邻接植花().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] gardenNoAdj(int n, int[][] paths) {
            List<Integer>[] lists = new ArrayList[n];
            Arrays.setAll(lists, e -> new ArrayList<>());
            for (int[] path : paths) {
                int x = path[0] - 1, y = path[1] - 1;
                lists[x].add(y);
                lists[y].add(x);
            }
            int[] ans = new int[n];
            for (int i = 0; i < lists.length; i++) {
                boolean[] used = new boolean[5];
                for (Integer j : lists[i]) {
                    used[ans[j]] = true;
                }
                while (used[++ans[i]]) ;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}