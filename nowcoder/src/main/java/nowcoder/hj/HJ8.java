/**
 * @Author: Neo
 * @Date: 2023/07/02 Sunday 16:53:55 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Map<Integer, Integer> map = new TreeMap<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int idx = in.nextInt();
            int val = in.nextInt();
            map.put(idx, map.getOrDefault(idx, 0) + val);
        }
        for (Integer k : map.keySet()) {
            System.out.println(k + " " + map.get(k));
        }
    }
}
