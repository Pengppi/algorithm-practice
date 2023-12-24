/**
 * @Author: Neo
 * @Date: 2023/12/24 星期日 10:44 上午
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class WeeklyContest377 {
    class Solution {

        /**
         * @title 100158. 转换字符串的最小成本 II
         * @url https://leetcode.cn/problems/minimum-cost-to-convert-string-ii/description/
         */
        public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
            int n = cost.length;
            dist = new int[2 * n][2 * n];
            for (int i = 0; i < 2 * n; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }
            for (int i = 0; i < n; i++) {
                int x = insertTire(original[i]);
                int y = insertTire(changed[i]);
                dist[x][y] = Math.min(dist[x][y], cost[i]);
            }
            for (int k = 0; k < sid; k++) {
                for (int i = 0; i < sid; i++) {
                    if (dist[i][k] == INF) {
                        continue;
                    }
                    for (int j = 0; j < sid; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
            s = source.toCharArray();
            t = target.toCharArray();
            memo = new long[source.length()];
            Arrays.fill(memo, -1);
            long ans = dfs(0);
            return ans < Long.MAX_VALUE / 2 ? ans : -1;
        }

        private long dfs(int i) {
            if (i >= s.length) {
                return 0;
            }
            if (memo[i] != -1) {
                return memo[i];
            }
            long res = Long.MAX_VALUE / 2;
            if (s[i] == t[i]) {
                res = dfs(i + 1);
            }
            Trie p = root, q = root;
            for (int j = i; j < s.length; j++) {
                p = p.son[s[j] - 'a'];
                q = q.son[t[j] - 'a'];
                if (p == null || q == null) {
                    break;
                }
                if (p.sid < 0 || q.sid < 0) {
                    continue;
                }
                int d = dist[p.sid][q.sid];
                if (d < INF) {
                    res = Math.min(res, d + dfs(j + 1));
                }
            }
            return memo[i] = res;
        }

        private int insertTire(String s) {
            Trie node = root;
            for (char c : s.toCharArray()) {
                int pos = c - 'a';
                if (node.son[pos] == null) {
                    node.son[pos] = new Trie();
                }
                node = node.son[pos];
            }
            if (node.sid < 0) {
                node.sid = sid++;
            }
            return node.sid;
        }

        private Trie root = new Trie();
        private int[][] dist;
        private int sid = 0;
        private char[] s, t;
        private long[] memo;
        private final int INF = Integer.MAX_VALUE / 2;

        class Trie {
            Trie[] son = new Trie[26];
            int sid = -1;
        }


        /**
         * @title 100156. 转换字符串的最小成本 I
         * @url https://leetcode.cn/problems/minimum-cost-to-convert-string-i/description/
         */
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            if (source.length() != target.length()) {
                return -1;
            }
            int inf = Integer.MAX_VALUE / 2;
            int[][] dist = new int[26][26];
            for (int i = 0; i < 26; i++) {
                Arrays.fill(dist[i], inf);
                dist[i][i] = 0;
            }
            for (int i = 0; i < original.length; i++) {
                int a = original[i] - 'a';
                int b = changed[i] - 'a';
                dist[a][b] = Math.min(dist[a][b], cost[i]);
            }
            for (int k = 0; k < 26; k++) {
                for (int i = 0; i < 26; i++) {
                    for (int j = 0; j < 26; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
            long sum = 0;
            for (int i = 0; i < source.length(); i++) {
                int a = source.charAt(i) - 'a', b = target.charAt(i) - 'a';
                int d = dist[a][b];
                if (d == inf) {
                    return -1;
                }
                sum += d;
            }
            return sum;
        }

        /**
         * @title 100169. 移除栅栏得到的正方形田地的最大面积
         * @url https://leetcode.cn/problems/maximum-square-area-by-removing-fences-from-a-field/
         */
        public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
            int MOD = (int) 1e9 + 7;
            Set<Integer> hs = new HashSet<>();
            hs.add(m - 1);
            for (int i = 0; i < hFences.length; i++) {
                hs.add(hFences[i] - 1);
                hs.add(m - hFences[i]);
                for (int j = 0; j < i; j++) {
                    hs.add(Math.abs(hFences[i] - hFences[j]));
                }
            }

            long ans = -1;
            if (hs.contains(n - 1)) {
                ans = n - 1;
                return (int) (ans * ans % MOD);
            }
            for (int i = 0; i < vFences.length; i++) {
                if (hs.contains(vFences[i] - 1)) {
                    ans = Math.max(ans, vFences[i] - 1);
                }
                if (hs.contains(n - vFences[i])) {
                    ans = Math.max(ans, n - vFences[i]);
                }
                for (int j = 0; j < i; j++) {
                    int len = Math.abs(vFences[i] - vFences[j]);
                    if (hs.contains(len)) {
                        ans = Math.max(ans, len);
                    }
                }

            }

            if (ans == -1) {
                return -1;
            }
            return (int) (ans * ans % MOD);
        }

        /**
         * @title 100148. 最小数字游戏
         * @url https://leetcode.cn/problems/minimum-number-game/
         */
        public int[] numberGame(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int x : nums) {
                pq.offer(x);
            }
            int[] ans = new int[nums.length];
            int idx = 0;
            while (!pq.isEmpty()) {
                int a = pq.poll(), b = pq.poll();
                ans[idx++] = b;
                ans[idx++] = a;
            }
            return ans;
        }
    }
}
