/**
 * @Author: Neo
 * @Date: 2023/07/06 Thursday 19:09:16 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int k = in.nextInt();
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            String score = in.next();
            list.add(new String[]{name, score});
        }
        if (k == 0) {
            list.sort((a, b) -> (Integer.valueOf(b[1]) - Integer.valueOf(a[1])));
        }else{
            list.sort((a, b) -> (Integer.valueOf(a[1]) - Integer.valueOf(b[1])));
        }
        for (String[] s : list) {
            System.out.println(s[0]+" "+s[1]);
        }
    }
}
