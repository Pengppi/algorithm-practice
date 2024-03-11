/**
 * @Title: 207.课程表
 * @TitleSlug: courseSchedule
 * @Author: Neo
 * @Date: 2024-03-11 14:25:53
 */
package leetcode.editor.cn;

import java.util.*;

public class 课程表courseSchedule {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 课程表courseSchedule().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] g = new List[numCourses];
            Arrays.setAll(g, e -> new ArrayList<>());
            int[] inDegree = new int[numCourses];
            for (int[] p : prerequisites) {
                g[p[1]].add(p[0]);
                inDegree[p[0]]++;
            }
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int x = queue.poll();
                numCourses--;
                for (int y : g[x]) {
                    if (--inDegree[y] == 0) {
                        queue.offer(y);
                    }
                }
            }
            return numCourses == 0;
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       