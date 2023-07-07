/**
 * @Author: Neo
 * @Date: 2023/06/29 Thursday 17:43:47 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.Scanner;

public class HJ5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            System.out.println(f(in.next()));
        }
    }

    private static int f(String s) {
        return Integer.parseInt(s.substring(2), 16);
    }
}
