/**
 * @Author: Neo
 * @Date: 2023/06/29 Thursday 14:24:42 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hjPractice;

public class P0626 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(solution(nums));

        nums = new int[][]{
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        System.out.println(solution(nums));

        nums = new int[][]{
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(solution(nums));
    }

    public static int solution(int[][] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int m = nums[0].length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 1) {
                    dfs(nums, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private static void dfs(int[][] nums, int x, int y) {
        if (nums[x][y] == 0) {
            return;
        }
        nums[x][y] = 0;
        int n = nums.length, m = nums[0].length;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || i >= n || j < 0 || j >= m) {
                    continue;
                }
                if (nums[i][j] == 1) {
                    dfs(nums, i, j);
                }
            }
        }
    }
}
