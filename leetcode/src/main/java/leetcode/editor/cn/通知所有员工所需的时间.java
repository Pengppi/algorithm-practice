/**
 * @Title: 1376.通知所有员工所需的时间
 * @TitleSlug: timeNeededToInformAllEmployees
 * @Author: Neo
 * @Date: 2023-05-01 14:24:02
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

public class 通知所有员工所需的时间 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 通知所有员工所需的时间().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            List<Integer>[] lists = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                int head = manager[i];
                if (head != -1) {
                    lists[head].add(i);
                }
            }
            return dfs(lists, informTime, headID);
        }

        public int dfs(List<Integer>[] lists, int[] informTime, int id) {
            int n = lists[id].size();
            if (n == 0) {
                return 0;
            }
            int time = 0;
            for (int i = 0; i < n; i++) {
                time = Math.max(time, dfs(lists, informTime, lists[id].get(i)));
            }
            return time + informTime[id];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       