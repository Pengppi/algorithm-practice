/**
 * @Author: Neo
 * @Date: 2024/04/21 Sunday 10:14
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.*;

public class WeeklyContest394 {
    
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cnt = new int[n][10];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int j = 0; j < n; j++) {
            int mx = 0, mxCnt = 0;
            for (int i = 0; i < m; i++) {
                cnt[j][grid[i][j]]++;
            }
        }
        return 0;
    }
    
    
    public int numberOfSpecialChars(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else if (Character.isLowerCase(c)) {
                map.put(c, i);
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            char lower = (char) ('a' + i);
            char upper = (char) ('A' + i);
            if (map.containsKey(lower) && map.containsKey(upper) && map.get(lower) < map.get(upper)) {
                ans++;
            }
        }
        return ans;
    }
    
    public int numberOfSpecialChars1(String word) {
        Set<Character> set = new HashSet<>();
        for (char c : word.toCharArray()) {
            set.add(c);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            char lower = (char) ('a' + i);
            char upper = (char) ('A' + i);
            if (set.contains(lower) && set.contains(upper)) {
                ans++;
            }
        }
        return ans;
        
    }
    
    
}
