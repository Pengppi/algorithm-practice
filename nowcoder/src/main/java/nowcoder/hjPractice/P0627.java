/**
 * @Author: Neo
 * @Date: 2023/06/28 Wednesday 0:22:39 AM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hjPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P0627 {
    public static void main(String[] args) {
        String card = "3-3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A";
        String used = "4-5-6-7-8-8-8";
        System.out.println(solution(card, used));

        card="3-3-3-3-8-8-8-8";
        used="K-K-K-K";
        System.out.println(solution(card,used));
    }

    public static String solution(String card, String used) {
        String[] sequence = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < sequence.length; i++) {
            map.put(sequence[i], i);
        }

        int[] left = new int[sequence.length];
        Arrays.fill(left, 4);

        for (String s : card.split("-")) {
            if ("2".equals(s) || "B".equals(s) || "C".equals(s)) {
                continue;
            }
            int idx = map.get(s);
            left[idx]--;
        }
        for (String s : used.split("-")) {
            if ("2".equals(s) || "B".equals(s) || "C".equals(s)) {
                continue;
            }
            int idx = map.get(s);
            left[idx]--;
        }
        int cnt = 0, last = 0, len = 0;
        for (int i = 0; i < left.length; i++) {
            if (left[i] > 0) {
                cnt++;
            } else {
                if (cnt >= len) {
                    last = i - cnt;
                    len = cnt;
                }
                cnt = 0;
            }
        }
        if (cnt >= len) {
            last = left.length - cnt;
            len = cnt;
        }
        if (len < 5) {
            return "NO-CHAIN";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = last; i < last + len; i++) {
            sb.append(sequence[i]);
            if (i + 1 != last + len) {
                sb.append("-");
            }
        }
        return sb.toString();

    }

}

