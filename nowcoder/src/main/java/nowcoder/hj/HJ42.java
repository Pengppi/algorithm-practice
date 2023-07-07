/**
 * @Author: Neo
 * @Date: 2023/07/07 Friday 19:39:20 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.Scanner;

public class HJ42 {
    private static String[] ones = new String[]{
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "forteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};

    private static String[] twieties = new String[]{"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int x = in.nextInt();
        String ans = f(x);
        System.out.println(ans);

    }

    private static String f(int num) {
        String res = "";
        if (num <= 20) {
            res = ones[num];
        } else if (num < 100) {
            int rem = num % 10;
            res = twieties[num / 10];
            if (rem != 0) {
                res += " " + ones[rem];
            }
        } else if (num < 1000) {
            int rem = num % 100;
            res = ones[num / 100] + " hundred";
            if (rem != 0) {
                res += " and " + f(rem);
            }
        } else if (num < 1000_000) {
            int rem = num % 1000;
            res = f(num / 1000) + " thousand";
            if (rem != 0) {
                res += " " + f(rem);
            }
        } else if (num < 1000_000_000) {
            int rem = num % 1_000_000;
            res = f(num / 1000000) + " million";
            if (rem != 0) {
                res += " " + f(rem);
            }
        }
        return res;
    }
}
