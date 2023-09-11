/**
 * @Title: 207.课程表
 * @TitleSlug: courseSchedule
 * @Author: Neo
 * @Date: 2023-09-11 14:44:00
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 课程表 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 课程表().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] lists = new List[numCourses];
            for (int i = 0; i < numCourses; i++) {
                lists[i] = new ArrayList<>();
            }
            int[] inDegree = new int[numCourses];
            for (int[] p : prerequisites) {
                lists[p[1]].add(p[0]);
                inDegree[p[0]]++;
            }
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
            int cnt = 0;
            while (!queue.isEmpty()) {
                int t = queue.poll();
                for (Integer i : lists[t]) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.add(i);
                    }
                }
                cnt++;
            }
            return cnt == numCourses;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       