/**
 * @Title: 剑指 Offer 13.机器人的运动范围
 * @TitleSlug: jiQiRenDeYunDongFanWeiLcof
 * @Author: Neo
 * @Date: 2023-05-11 14:31:47
 */
package leetcode.editor.cn;

public class 机器人的运动范围 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 机器人的运动范围().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            int ans = 0;
            boolean[][] visited = new boolean[m][n];
            int x = 0, y = 0;
            for (y = 0; y < n; y++) {
                if (sumOfNum(y) > k) {
                    break;
                }
                visited[0][y] = true;
                ans++;
            }
            for (x = 1; x < m; x++) {
                if (sumOfNum(x) > k) {
                    break;
                }
                visited[x][0] = true;
                ans++;
            }
            for (int i = 1; i < x; i++) {
                for (int j = 1; j < y; j++) {
                    if (sumOfNum(i) + sumOfNum(j) <= k) {
                        if (visited[i - 1][j] || visited[i][j - 1]) {
                            visited[i][j] = true;
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }

        private int sumOfNum(int x) {
            int ans = 0;
            while (x > 0) {
                ans += x % 10;
                x /= 10;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       