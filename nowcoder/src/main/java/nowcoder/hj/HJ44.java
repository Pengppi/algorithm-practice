/**
 * @Author: Neo
 * @Date: 2023/07/06 Thursday 21:42:05 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.Scanner;

public class HJ44 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = 9;
        int[][] matrix = new int[n][n];
        int[] rUsed = new int[n];
        int[] cUsed = new int[n];
        int[][] bUsed = new int[3][3];
        while (in.hasNext()) { // 注意 while 处理多个 case
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int k = in.nextInt();
                    matrix[i][j] = k;
                    rUsed[i] |= 1 << k;
                    cUsed[j] |= 1 << k;
                    bUsed[i / 3][j / 3] |= 1 << k;
                }
            }
            dfs(matrix, bUsed, rUsed, cUsed, 0, 0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0) {
                        System.out.print(" ");
                    }
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static boolean dfs(int[][] mat, int[][] bUsed, int[] rUsed, int[] cUsed, int i, int j) {
        if (j == mat[0].length) {
            j = 0;
            i++;
            if (i == mat.length) {
                return true;
            }
        }
        if (mat[i][j] != 0) {
            return dfs(mat, bUsed, rUsed, cUsed, i, j + 1);
        }
        for (int k = 1; k <= 9; k++) {
            if (((rUsed[i] >> k) & 1) == 1) {
                continue;
            }
            if (((cUsed[j] >> k) & 1) == 1) {
                continue;
            }
            if (((bUsed[i / 3][j / 3] >> k) & 1) == 1) {
                continue;
            }
            rUsed[i] |= 1 << k;
            cUsed[j] |= 1 << k;
            bUsed[i / 3][j / 3] |= 1 << k;
            mat[i][j] = k;
            if (dfs(mat, bUsed, rUsed, cUsed, i, j + 1)) {
                return true;
            }
            mat[i][j] = 0;
            rUsed[i] &= ~(1 << k);
            cUsed[j] &= ~(1 << k);
            bUsed[i / 3][j / 3] &= ~(1 << k);
        }
        return false;
    }
}
