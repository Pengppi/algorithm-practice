/**
 * @Author: Neo
 * @Date: 2023/07/02 Sunday 15:16:36 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.next());
        }
        String x = in.next();
        for (int i = n - 1; i >= 0; i--) {
            if (!valid(list.get(i), x)) {
                list.remove(i);
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        int k = in.nextInt();
        if (k < list.size()) {
            System.out.println(list.get(k - 1));
        }
    }

    private static boolean valid(String a, String b) {
        if (a.length() != b.length() || a.equals(b)) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < a.length(); i++) {
            cnt[a.charAt(i) - 'a']++;
            cnt[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
