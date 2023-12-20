/**
 * @Title: 2866.美丽塔 II
 * @TitleSlug: beautifulTowersIi
 * @Author: Neo
 * @Date: 2023-12-21 00:12:34
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class 美丽塔II {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 美丽塔II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            int n = maxHeights.size();
            Deque<Integer> st = new ArrayDeque<>();
            long[] suf = new long[n + 1];
            st.push(n);
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                int h = maxHeights.get(i);
                while (st.size() > 1 && h <= maxHeights.get(st.peek())) {
                    int j = st.pop();
                    int x = maxHeights.get(j);
                    sum -= (long) x * (st.peek() - j);
                }
                sum += (long) h * (st.peek() - i);
                suf[i] = sum;
                st.push(i);
            }
            st.clear();
            st.push(-1);
            long ans = sum, pre = 0;
            for (int i = 0; i < n; i++) {
                int h = maxHeights.get(i);
                while (st.size() > 1 && h <= maxHeights.get(st.peek())) {
                    int j = st.pop();
                    int x = maxHeights.get(j);
                    pre -= (long) x * (j - st.peek());
                }
                pre += (long) h * (i - st.peek());
                ans = Math.max(ans, pre + suf[i + 1]);
                st.push(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       