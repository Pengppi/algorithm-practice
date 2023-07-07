/**
 * @Author: Neo
 * @Date: 2023/07/02 Sunday 14:08:06 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.Scanner;

public class HJ16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt(), m = in.nextInt();
        int[][] w = new int[m + 1][3];
        int[][] c = new int[m + 1][3];
        int mn = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            int v = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            mn = Math.min(mn, v);
            if (q == 0) {
                w[i][0] = v;
                c[i][0] = v * p;
            } else if (w[q][1] == 0) {
                w[q][1] = v;
                c[q][1] = v * p;
            } else {
                w[q][2] = v;
                c[q][2] = v * p;
            }
        }
        int d = 1;
        while (mn >= 10) {
            d *= 10;
            mn /= 10;
        }
        n /= mn;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 3; j++) {
                w[i][j] /= mn;
            }
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                int t;
                if (j >= w[i][0]) {
                    t = dp[i - 1][j - w[i][0]] + c[i][0];
                    dp[i][j] = Math.max(dp[i][j], t);
                }
                if (j >= w[i][0] + w[i][1]) {
                    t = dp[i - 1][j - w[i][0] - w[i][1]] + c[i][0] + c[i][1];
                    dp[i][j] = Math.max(dp[i][j], t);
                }
                if (j >= w[i][0] + w[i][2]) {
                    t = dp[i - 1][j - w[i][0] - w[i][2]] + c[i][0] + c[i][2];
                    dp[i][j] = Math.max(dp[i][j], t);
                }
                if (j >= w[i][0] + w[i][1] + w[i][2]) {
                    t = dp[i - 1][j - w[i][0] - w[i][1] - w[i][2]] + c[i][0] + c[i][1] + c[i][2];
                    dp[i][j] = Math.max(dp[i][j], t);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
