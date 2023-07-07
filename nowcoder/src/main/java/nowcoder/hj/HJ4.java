/**
 * @Author: Neo
 * @Date: 2023/06/29 Thursday 18:09:47 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.Scanner;

public class HJ4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String x = in.next();
            if (x.isEmpty()) {
                continue;
            }
            while (x.length() > 8) {
                System.out.println(x.substring(0, 8));
                x = x.substring(8);
            }
            StringBuilder sb = new StringBuilder(x);
            while (sb.length() < 8) {
                sb.append(0);
            }
            System.out.println(sb.toString());
        }
    }
}
