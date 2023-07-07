/**
 * @Author: Neo
 * @Date: 2023/07/05 Wednesday 17:57:50 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hjPractice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P0704 {
    static int ans = Integer.MAX_VALUE;

    static Set<Long> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        long x = in.nextLong();
        dfs(x, 0);
        System.out.println(ans);
    }

    private static void dfs(long x, int cnt) {
        if (x == 1) {
            ans = Math.min(ans, cnt);
        } else if (x % 2 == 0) {
            dfs(x / 2, cnt + 1);
        } else {
            dfs(x + 1, cnt + 1);
            dfs(x - 1, cnt + 1);
        }
    }

}
