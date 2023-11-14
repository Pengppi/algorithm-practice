/**
 * @Title: 1466.重新规划路线
 * @TitleSlug: reorderRoutesToMakeAllPathsLeadToTheCityZero
 * @Author: Neo
 * @Date: 2023-11-13 13:47:30
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 重新规划路线 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 重新规划路线().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minReorder(int n, int[][] connections) {
            List<Integer>[] in = new List[n];
            List<Integer>[] out = new List[n];
            for (int i = 0; i < n; i++) {
                in[i] = new ArrayList<>();
                out[i] = new ArrayList<>();
            }
            for (int[] conn : connections) {
                int a = conn[0], b = conn[1];
                out[a].add(b);
                in[b].add(a);
            }
            boolean[] isVisted = new boolean[n];
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(0);
            isVisted[0] = true;
            int cnt = 0;
            while (!q.isEmpty()) {
                int p = q.poll();
                for (Integer x : in[p]) {
                    if (!isVisted[x]) {
                        isVisted[x] = true;
                        q.offer(x);
                    }
                }
                for (Integer x : out[p]) {
                    if (!isVisted[x]) {
                        isVisted[x] = true;
                        q.offer(x);
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       