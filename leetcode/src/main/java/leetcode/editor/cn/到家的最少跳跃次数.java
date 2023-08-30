/**
 * @Title: 1654.到家的最少跳跃次数
 * @TitleSlug: minimumJumpsToReachHome
 * @Author: Neo
 * @Date: 2023-08-30 21:07:10
 */
package leetcode.editor.cn;

public class 到家的最少跳跃次数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 到家的最少跳跃次数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int a, b, x, max;
        boolean[] visted;

        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            if (x == 0) {
                return 0;
            }
            this.a = a;
            this.b = b;
            this.x = x;
            max = 2000 + a + b;
            visted = new boolean[max + 1];
            for (int i : forbidden) {
                visted[i] = true;
            }
            return dfs(a, 0, true);
        }

        private int dfs(int cur, int steps, boolean isForward) {
            if (cur < 0 || cur > max || visted[cur]) {
                return -1;
            }
            steps++;
            if (cur == x) {
                return steps;
            }
            if (isForward) {
                visted[cur] = true;
            }
            int nextForwardPos = cur + a, nextBackwardPos = cur - b;
            int forwardStep = -1, backwardStep = -1;
            if (nextBackwardPos >= x) {
                if (isForward) {
                    backwardStep = dfs(nextBackwardPos, steps, false);
                }
                if (backwardStep == -1) {
                    forwardStep = dfs(nextForwardPos, steps, true);
                }
            } else {
                forwardStep = dfs(nextForwardPos, steps, true);
                if (forwardStep == -1 && isForward) {
                    backwardStep = dfs(nextBackwardPos, steps, false);
                }
            }
            return forwardStep == -1 ? backwardStep : forwardStep;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       