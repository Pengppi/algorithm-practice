/**
 * @Author: Neo
 * @Date: 2023/06/29 Thursday 17:59:00 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            System.out.println(f(in.next()));
        }
    }

    private static int f(String s) {
        char[] cs = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : cs) {
            if (c >= 0 && c <= 127) {
                set.add(c);
            }
        }
        return set.size();
    }
}
