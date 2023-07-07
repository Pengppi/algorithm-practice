/**
 * @Title: 2432.处理用时最长的那个任务的员工
 * @TitleSlug: theEmployeeThatWorkedOnTheLongestTask
 * @Author: Neo
 * @Date: 2023-05-05 13:41:06
 */
package leetcode.editor.cn;

public class 处理用时最长的那个任务的员工 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 处理用时最长的那个任务的员工().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hardestWorker(int n, int[][] logs) {
            int maxTime = logs[0][1];
            int ans = logs[0][0];
            for (int i = 1; i < logs.length; i++) {
                int takeTime = logs[i][1] - logs[i - 1][1];
                if (takeTime > maxTime) {
                    maxTime = takeTime;
                    ans = logs[i][0];
                }
                if (takeTime == maxTime) {
                    ans = Math.min(ans, logs[i][0]);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       