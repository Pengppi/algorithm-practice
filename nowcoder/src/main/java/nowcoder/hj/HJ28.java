/**
 * @Author: Neo
 * @Date: 2023/07/06 Thursday 20:38:16 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ28 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if ((x & 1) == 1) {
                odds.add(x);
            } else {
                evens.add(x);
            }
        }
        int ans = 0;
        int len = evens.size();
        int[] evenMatch = new int[len];
        for (Integer odd : odds) {
            int[] used = new int[len];
            if (find(odd, evens, used, evenMatch)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean find(int x, List<Integer> evens, int[] used, int[] evenMatch) {
        for (int i = 0; i < evens.size(); i++) {
            if (used[i] != 1 && isPrime(x + evens.get(i))) {
                used[i] = 1;
                if (evenMatch[i] == 0 || find(evenMatch[i], evens, used, evenMatch)) {
                    evenMatch[i] = x;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
