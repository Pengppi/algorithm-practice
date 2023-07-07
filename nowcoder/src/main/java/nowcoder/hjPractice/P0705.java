/**
 * @Author: Neo
 * @Date: 2023/07/05 Wednesday 17:46:42 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hjPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class P0705 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.next());
        }
        list.sort((a, b) -> (a.charAt(a.length() - 1) - b.charAt(b.length() - 1)));
        StringJoiner sj = new StringJoiner(" ");
        for (String s : list) {
            int len = s.length();
            sj.add(s.substring(0, len - 1));
        }
        System.out.println(sj.toString());

    }
}
