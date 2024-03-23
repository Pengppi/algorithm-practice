/**
 * @Title: 134.加油站
 * @TitleSlug: gasStation
 * @Author: Neo
 * @Date: 2024-03-23 17:54:38
 */
package leetcode.editor.cn;

public class 加油站gasStation {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 加油站gasStation().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int leftSum = 0;
            int curSum = 0;
            int start = -1;
            for (int i = 0; i < n; i++) {
                int cur = gas[i] - cost[i];
                if (curSum + cur < 0) {
                    leftSum += curSum + cur;
                    curSum = 0;
                    start = -1;
                } else {
                    curSum += cur;
                    if (start == -1) {
                        start = i;
                    }
                }
            }
            return curSum + leftSum < 0 ? -1 : start;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       