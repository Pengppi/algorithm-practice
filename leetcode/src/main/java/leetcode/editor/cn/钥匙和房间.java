/**
 * @Title: 841.钥匙和房间
 * @TitleSlug: keysAndRooms
 * @Author: Neo
 * @Date: 2023-11-02 10:41:27
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class 钥匙和房间 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 钥匙和房间().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
            boolean[] isVis = new boolean[n];
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(0);
            isVis[0] = true;
            while (!q.isEmpty()) {
                int id = q.poll();
                for (Integer x : rooms.get(id)) {
                    if (!isVis[x]) {
                        q.offer(x);
                        isVis[x] = true;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (!isVis[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       