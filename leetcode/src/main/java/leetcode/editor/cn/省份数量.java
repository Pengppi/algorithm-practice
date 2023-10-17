/**
 * @Title: 547.省份数量
 * @TitleSlug: numberOfProvinces
 * @Author: Neo
 * @Date: 2023-10-17 14:31:58
 */
package leetcode.editor.cn;

public class 省份数量 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 省份数量().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int ans = 0, n = isConnected.length;
            boolean[] isVisted = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!isVisted[i]) {
                    ans++;
                    dfs(i, isConnected, isVisted);
                }
            }
            return ans;
        }

        private void dfs(int i, int[][] isConnected, boolean[] isVisted) {
            isVisted[i] = true;
            for (int j = 0; j < isConnected.length; j++) {
                if (!isVisted[j] && isConnected[i][j] == 1) {
                    dfs(j, isConnected, isVisted);
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       