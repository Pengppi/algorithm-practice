/**
 * @Title: 2127.参加会议的最多员工数
 * @TitleSlug: maximumEmployeesToBeInvitedToAMeeting
 * @Author: Neo
 * @Date: 2023-11-01 14:41:35
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 参加会议的最多员工数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 参加会议的最多员工数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumInvitations(int[] favorite) {
            int n = favorite.length;
            int[] deg = new int[n];
            List<Integer>[] rg = new List[n];
            for (int i = 0; i < n; i++) {
                rg[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                deg[favorite[i]]++;
            }
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (deg[i] == 0) {
                    q.offer(i);
                }
            }
            while (!q.isEmpty()) {
                int x = q.poll();
                int y = favorite[x];
                rg[y].add(x);
                if (--deg[y] == 0) {
                    q.offer(y);
                }
            }
            int maxRingSize = 0, sumChainSize = 0;
            for (int i = 0; i < n; i++) {
                if (deg[i] == 0) {
                    continue;
                }
                deg[i] = 0;
                int ringSize = 1;
                for (int x = favorite[i]; x != i; x = favorite[x]) {
                    deg[x] = 0;
                    ringSize++;
                }
                if (ringSize == 2) {
                    sumChainSize += dfs(i, rg) + dfs(favorite[i], rg);
                } else {
                    maxRingSize = Math.max(maxRingSize, ringSize);
                }

            }
            return Math.max(sumChainSize, maxRingSize);
        }

        private int dfs(int x, List<Integer>[] rg) {
            int depth = 0;
            for (Integer i : rg[x]) {
                depth = Math.max(depth, dfs(i, rg));
            }
            return depth + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       