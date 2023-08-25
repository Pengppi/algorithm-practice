/**
 * @Title: 1267.统计参与通信的服务器
 * @TitleSlug: countServersThatCommunicate
 * @Author: Neo
 * @Date: 2023-08-24 18:49:41
 */
package leetcode.editor.cn;

public class 统计参与通信的服务器 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 统计参与通信的服务器().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countServers(int[][] grid) {
            int m = grid.length, n = grid[0].length, ans = 0;
            int[] rows = new int[m];
            int[] cols = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        rows[i]++;
                        cols[j]++;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        if (rows[i] >= 2 || cols[j] >= 2) {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       