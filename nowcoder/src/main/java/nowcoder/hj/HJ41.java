/**
 * @Author: Neo
 * @Date: 2023/07/06 Thursday 19:22:31 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.*;

public class HJ41 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        Set<Integer> ans = new HashSet<>();
        int[] w = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        ans.add(0);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(ans);
            for (int j = 1; j <= c[i]; j++) {
                for (int k = 0; k < list.size(); k++) {
                    ans.add(list.get(k) + w[i] * j);
                }
            }
        }
        System.out.println(ans.size());
    }


}
