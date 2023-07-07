/**
 * @Author: Neo
 * @Date: 2023/06/29 Thursday 15:45:56 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hjPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P0629 {
    public static void main(String[] args) {
        System.out.println(solution("bA#aAc!Bb"));
        System.out.println(solution("aabbcc"));
    }

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }
        str = sb.toString().toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        int n = str.length();
        List<int[]> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            char c = str.charAt(i);
            int j = i;
            while (j >= 0 && str.charAt(j) == c) {
                j--;
            }
            int cnt;
            if (i - j > 1) {
                cnt = i - j;
                map.put(c, map.getOrDefault(c, 0) + cnt);
                i = j + 1;
            } else {
                cnt = map.getOrDefault(c, 0);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            list.add(new int[]{(int) c, cnt});

        }
        list.sort((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);
        sb = new StringBuilder();
        for (int[] x : list) {
            sb.append((char) x[0]).append(x[1]);
        }
        return sb.toString();
    }
}
