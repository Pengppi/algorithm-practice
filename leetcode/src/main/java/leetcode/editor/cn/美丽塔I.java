/**
 * @Title: 2865.美丽塔 I
 * @TitleSlug: beautifulTowersI
 * @Author: Neo
 * @Date: 2024-01-24 09:16:46
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class 美丽塔I {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 美丽塔I().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            int n = maxHeights.size();
            Deque<Integer> st = new ArrayDeque<>();
            long[] sufSum = new long[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && maxHeights.get(i) < maxHeights.get(st.peek())) {
                    st.pop();
                }
                int last = st.isEmpty() ? n : st.peek();
                sufSum[i] = (long) (last - i) * maxHeights.get(i) + sufSum[last];
                st.push(i);
            }
            st.clear();
            long[] preSum = new long[n + 1];
            long ans = 0;
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && maxHeights.get(i) < maxHeights.get(st.peek())) {
                    st.pop();
                }
                int last = st.isEmpty() ? -1 : st.peek();
                preSum[i + 1] = (long) (i - last) * maxHeights.get(i) + preSum[last + 1];
                st.push(i);
                ans = Math.max(ans, preSum[i] + sufSum[i]);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       