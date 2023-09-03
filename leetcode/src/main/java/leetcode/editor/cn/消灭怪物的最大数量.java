/**
 * @Title: 1921.消灭怪物的最大数量
 * @TitleSlug: eliminateMaximumNumberOfMonsters
 * @Author: Neo
 * @Date: 2023-09-03 23:16:31
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 消灭怪物的最大数量 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 消灭怪物的最大数量().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eliminateMaximum(int[] dist, int[] speed) {
            int ans = 0, n = dist.length;
            int[] arrival = new int[n];
            for (int i = 0; i < n; i++) {
                arrival[i] = (dist[i] - 1) / speed[i] + 1;
            }
            Arrays.sort(arrival);
            for (int i = 0; i < n; i++) {
                if (arrival[i] <= i) {
                    return i;
                }
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       