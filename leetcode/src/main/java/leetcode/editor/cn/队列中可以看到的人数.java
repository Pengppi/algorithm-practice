/**
 * @Title: 1944.队列中可以看到的人数
 * @TitleSlug: numberOfVisiblePeopleInAQueue
 * @Author: Neo
 * @Date: 2024-01-05 08:59:01
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 队列中可以看到的人数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 队列中可以看到的人数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            int[] ans = new int[n];
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && heights[st.peek()] < heights[i]) {
                    st.pop();
                    ans[i]++;
                }
                ans[i] += st.isEmpty() ? 0 : 1;
                st.push(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       