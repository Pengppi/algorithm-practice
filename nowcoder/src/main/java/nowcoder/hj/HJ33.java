/**
 * @Author: Neo
 * @Date: 2023/07/02 Sunday 17:57:23 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.Scanner;
import java.util.StringJoiner;

public class HJ33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String ip = in.next();
        System.out.println(IPToDecimal(ip));
        long decimal = in.nextLong();
        System.out.println(DecimalToIP(decimal));

    }

    private static String DecimalToIP(long decimal) {
        String binaryString = Long.toBinaryString(decimal);
        while (binaryString.length() < 32) {
            binaryString = "0" + binaryString;
        }
        StringJoiner ip = new StringJoiner(".");
        for (int i = 0; i < 4; i++) {
            int g = i * 8;
            String x = binaryString.substring(g, Math.min(8 + g, 32));
            ip.add(String.valueOf(Integer.valueOf(x, 2)));
        }
        return ip.toString();
    }

    private static Long IPToDecimal(String ip) {
        String[] nums = ip.split("\\.");
        StringBuilder binary = new StringBuilder();
        for (String num : nums) {
            String binStr = Integer.toBinaryString(Integer.valueOf(num));
            for (int i = 0; i < 8 - binStr.length(); i++) {
                binary.append(0);
            }
            binary.append(binStr);
        }
        return Long.valueOf(binary.toString(), 2);
    }
}
