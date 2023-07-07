/**
 * @Author: Neo
 * @Date: 2023/06/29 Thursday 17:39:16 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.next();
            System.out.println(check(s));
        }
    }

    private static String check(String s) {
        if (s.length() <= 8) {
            return "NG";
        }
        char[] cs = s.toCharArray();
        int flg = 0;
        for (char c : cs) {
            if (Character.isUpperCase(c)) {
                flg |= 1;
            } else if (Character.isLowerCase(c)) {
                flg |= (1 << 1);
            } else if (Character.isDigit(c)) {
                flg |= (1 << 2);
            } else {
                flg |= (1 << 3);
            }
            if (Integer.bitCount(flg) >= 3) {
                break;
            }
        }
        if (Integer.bitCount(flg) < 3) {
            return "NG";
        }
        Set<String> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n - 2; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + 3; j++) {
                sb.append(cs[j]);
            }
            if (!set.add(sb.toString())) {
                return "NG";
            }
        }
        return "OK";
    }
}
