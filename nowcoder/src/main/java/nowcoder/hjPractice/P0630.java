/**
 * @Author: Neo
 * @Date: 2023/07/02 Sunday 12:59:19 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hjPractice;

import java.util.*;

public class P0630 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] m = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            m[i] = in.nextInt();
            sum += m[i];
        }
        if (sum % 2 != 0) {
            System.out.println(-1);
        } else {
            System.out.println(f(m, sum / 2));
        }
    }

    private static int f(int[] nums, int target) {
        int n = nums.length;
        int max = Integer.MAX_VALUE / 2;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= target; i++) {
            dp[n][i] = max;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= target; j++) {
                int cur = nums[i] > j ? max : 1 + dp[i + 1][j - nums[i]];
                dp[i][j] = Math.min(dp[i + 1][j], cur);
            }
        }
        return dp[0][target]==max?-1:dp[0][target];
    }

}
