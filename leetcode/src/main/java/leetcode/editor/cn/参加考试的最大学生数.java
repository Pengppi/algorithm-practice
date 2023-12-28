/**
 * @Title: 1349.参加考试的最大学生数
 * @TitleSlug: maximumStudentsTakingExam
 * @Author: Neo
 * @Date: 2023-12-26 00:14:25
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 参加考试的最大学生数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 参加考试的最大学生数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int maxStudents(char[][] seats) {
            int m = seats.length;
            int n = seats[0].length;
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (seats[i][j] == '.') {
                        a[i] |= 1 << j;
                    }
                }
            }
            memo = new int[m][1 << n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(memo[i], -1);
            }
            return dfs(m - 1, a[m - 1], a);
        }

        private int dfs(int i, int j, int[] a) {
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            if (i == 0) {
                if (j == 0) {
                    return 0;
                }
                int lowBit = j & -j;
                return memo[i][j] = dfs(i, j & ~((lowBit << 1) | lowBit), a) + 1;
            }
            int res = dfs(i - 1, a[i - 1], a);// 第i排不坐人
            for (int s = j; s > 0; s = (s - 1) & j) {// 枚举 j 的子集 s
                if ((s & (s >> 1)) == 0) {// s 没有连续的 1
                    int t = a[i - 1] & ~(s << 1 | s >> 1);// 去掉不能坐人的位置
                    res = Math.max(res, dfs(i - 1, t, a) + Integer.bitCount(s));
                }
            }
            return memo[i][j]=res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
        
       