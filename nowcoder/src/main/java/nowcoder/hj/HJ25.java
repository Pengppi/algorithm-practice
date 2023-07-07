/**
 * @Author: Neo
 * @Date: 2023/07/06 Thursday 20:09:11 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.*;

public class HJ25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        List<String> I = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            I.add(in.next());
        }
        n = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        List<Integer> R = new ArrayList<>(set);
        Collections.sort(R);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < R.size(); i++) {
            int cnt = 0;
            List<Integer> list = new ArrayList<>();
            String r = String.valueOf(R.get(i));
            for (int j = 0; j < I.size(); j++) {
                if (I.get(j).contains(r)) {
                    cnt++;
                    list.add(j);
                    list.add(Integer.valueOf(I.get(j)));
                }
            }
            if (cnt != 0) {
                ans.add(R.get(i));
                ans.add(cnt);
                ans.addAll(list);
            }
        }
        System.out.print(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(" " + ans.get(i));
        }
    }
}
