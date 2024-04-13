/**
 * @Author: Neo
 * @Date: 2024/04/13 Saturday 22:30
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 3
 * [[0,1,2],[1,2,1],[0,2,4]]
 * [1,1,5]
 * 3
 * [[0,1,2],[1,2,1],[0,2,4]]
 * [1,3,5]
 * 2
 * [[0,1,1]]
 * [1,1]
 * 6
 * [[3,1,10],[2,1,2],[1,2,1],[0,5,2],[1,3,2],[3,2,9],[5,3,10]]
 * [11,17,7,5,2,3]
 * 6
 * [[0,4,7],[3,3,10],[4,4,10],[1,0,1],[5,5,1],[1,4,6],[3,5,9],[4,1,6],[2,2,7],[3,4,2]]
 * [20,10,5,7,16,20]
 */

public class BiweeklyContest128 {
    
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        final int inf = Integer.MAX_VALUE / 2;
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1], d = e[2];
            if (x == y) {
                continue;
            }
            g[x].add(new int[]{y, d});
            g[y].add(new int[]{x, d});
        }
        int[] dis = new int[n];
        Arrays.fill(dis, inf);
        dis[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0], dx = p[1];
            if (dx >= disappear[x] || dx > dis[x]) {
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0];
                int dy = dx + e[1];
                if (dy >= disappear[y]) {
                    continue;
                }
                if (dy < dis[y]) {
                    dis[y] = dy;
                    pq.offer(new int[]{y, dy});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dis[i] == inf || dis[i] >= disappear[i]) {
                dis[i] = -1;
            }
        }
        return dis;
    }
    
    
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int ans = 0;
        int last = points[0][0], i = 0;
        while (i < points.length) {
            while (i < points.length && points[i][0] <= last + w) {
                i++;
            }
            ans++;
            if (i == points.length) {
                break;
            }
            last = points[i][0];
        }
        return ans;
    }
    
    public int scoreOfString(String s) {
        char[] a = s.toCharArray();
        int ans = 0;
        for (int i = 1; i < a.length; i++) {
            ans += Math.abs(a[i] - a[i - 1]);
        }
        return ans;
    }
    
}
