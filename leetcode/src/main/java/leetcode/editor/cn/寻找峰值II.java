/**
 * @Title: 1901.寻找峰值 II
 * @TitleSlug: findAPeakElementIi
 * @Author: Neo
 * @Date: 2023-12-19 00:20:28
 */
package leetcode.editor.cn;

public class 寻找峰值II {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 寻找峰值II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int l = 0, r = m - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int j = -1, mx = -1;
                for (int k = 0; k < n; k++) {
                    if (mat[mid][k] > mx) {
                        j = k;
                        mx = mat[mid][k];
                    }
                }
                if (mid > 0 && mat[mid - 1][j] > mat[mid][j]) {
                    r = mid - 1;
                    continue;
                }
                if (mid + 1 < m && mat[mid + 1][j] > mat[mid][j]) {
                    l = mid + 1;
                    continue;
                }
                return new int[]{mid, j};
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       