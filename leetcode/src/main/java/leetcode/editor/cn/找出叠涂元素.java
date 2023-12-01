/**
 * @Title: 2661.找出叠涂元素
 * @TitleSlug: firstCompletelyPaintedRowOrColumn
 * @Author: Neo
 * @Date: 2023-12-01 01:34:48
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 找出叠涂元素 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 找出叠涂元素().new Solution();
        int arr[] = new int[]{1, 4, 5, 2, 6, 3};
        int[][] mat = new int[][]{{4, 3, 5}, {1, 2, 6}};
        solution.firstCompleteIndex(arr, mat);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int m = mat.length, n = mat[0].length;
            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map.put(mat[i][j], new int[]{i, j});
                }
            }
            int[] row = new int[m];
            int[] col = new int[n];
            for (int i = 0; i < m * n; i++) {
                int[] pos = map.get(arr[i]);
                int x = pos[0], y = pos[1];
                row[x]++;
                col[y]++;
                if (row[x] == n || col[y] == m) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       