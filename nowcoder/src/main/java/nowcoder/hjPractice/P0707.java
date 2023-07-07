/**
 * @Author: Neo
 * @Date: 2023/07/07 Friday 18:37:03 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hjPractice;

import java.util.Scanner;

public class P0707 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum[i + 1] = sum[i] + arr[i];
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int res = Math.abs(sum[n] -2*sum[i]);
            ans = Math.max(ans, res);
        }
        System.out.println(ans);
    }
}
