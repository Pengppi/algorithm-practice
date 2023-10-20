/**
 * @Title: 739.每日温度
 * @TitleSlug: dailyTemperatures
 * @Author: Neo
 * @Date: 2023-10-19 15:22:39
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 每日温度 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 每日温度().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            Deque<Integer> d = new ArrayDeque<>();
            int[] ans = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                while (!d.isEmpty() && temperatures[d.peekFirst()] <= temperatures[i]) {
                    d.pollFirst();
                }
                if (d.isEmpty()) {
                    ans[i] = 0;
                } else {
                    ans[i] = d.peekFirst() - i;
                }
                d.addFirst(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       