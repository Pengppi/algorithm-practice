/**
 * @Author: Neo
 * @Date: 2023/11/26 Sunday 06:50 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Pengppi
 * @date 2023/11/26
 * @url https://leetcode.cn/contest/weekly-contest-373/
 */
public class WeeklyContest373 {

    /**
     * @title 循环移位后的矩阵相似检查
     * @url https://leetcode.cn/problems/matrix-similarity-after-cyclic-shifts/
     */
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k %= n;
        for (int i = 0; i < m; i++) {
            if (i % 2 != 0) {//左移
                for (int j = 0; j < n; j++) {
                    if (j < k && mat[i][j] != mat[i][n - k + j]) {
                        return false;
                    } else if (j >= k && mat[i][j] != mat[i][j - k]) {
                        return false;
                    }
                }
            } else {//右移
                for (int j = 0; j < n; j++) {
                    if (j < n - k && mat[i][j] != mat[i][j + k]) {
                        return false;
                    } else if (j >= n - k && mat[i][j] != mat[i][j - (n - k)]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * @title 统计美丽子字符串 I
     * @url https://leetcode.cn/problems/count-beautiful-substrings-i/
     */
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] arr = s.toCharArray();
        int ans = 0;
        for (int i = 2; i <= n; i += 2) {
            if (i * i % (4 * k) == 0) {
                int v = 0, c = 0;
                for (int j = 0; j < n; j++) {
                    if (set.contains(arr[j])) {
                        v++;
                    } else {
                        c++;
                    }
                    if (j >= i) {
                        if (set.contains(arr[j - i])) {
                            v--;
                        } else {
                            c--;
                        }
                    }
                    if (j >= i - 1 && v == c) {
                        System.out.println(i + " " + j);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }



}
