/**
 * @Title: 1462.课程表 IV
 * @TitleSlug: courseScheduleIv
 * @Author: Neo
 * @Date: 2023-09-12 00:27:40
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 课程表IV {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 课程表IV().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            boolean[][] mat = new boolean[numCourses][numCourses];
            for (int[] prerequisite : prerequisites) {
                int a = prerequisite[0], b = prerequisite[1];
                mat[a][b] = true;
                for (int i = 0; i < numCourses; i++) {
                    if (mat[i][a] && !mat[i][b]) {
                        mat[i][b] = true;
                    }
                    if (mat[b][i] && !mat[a][i]) {
                        mat[a][i] = true;
                    }
                }
            }
            List<Boolean> ans = new ArrayList<>();
            for (int[] query : queries) {
                int u = query[0], v = query[1];
                ans.add(mat[u][v]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       