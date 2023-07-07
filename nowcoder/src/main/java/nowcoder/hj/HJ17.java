/**
 * @Author: Neo
 * @Date: 2023/07/02 Sunday 16:16:23 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String input = in.next();
        String[] commands = input.split(";");
        int x = 0, y = 0;
        for (String command : commands) {
            if (valid(command)) {
                int num = 0;
                for (int i = 1; i < command.length(); i++) {
                    num *= 10;
                    num += command.charAt(i) - '0';
                }
                char c = command.charAt(0);
                if (c == 'A')
                    x -= num;
                if (c == 'S')
                    y -= num;
                if (c == 'D')
                    x += num;
                if (c == 'W')
                    y += num;
            }

        }
        System.out.println(x + "," + y);
    }

    private static boolean valid(String s) {
        if (s.isEmpty()) {
            return false;
        }
        char[] cs = s.toCharArray();
        if (cs.length > 3) {
            return false;
        }
        if (cs[0] != 'A' && cs[0] != 'S' && cs[0] != 'D' && cs[0] != 'W') {
            return false;
        }
        for (int i = 1; i < cs.length; i++) {
            if (!Character.isDigit(cs[i])) {
                return false;
            }
        }
        return true;
    }
}
