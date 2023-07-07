/**
 * @Author: Neo
 * @Date: 2023/07/02 Sunday 17:50:08 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.next();
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = str.toCharArray();
        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int mn = Integer.MAX_VALUE;
        for (Integer v : map.values()) {
            mn = Math.min(mn, v);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (map.get(c) == mn) {
                continue;
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
