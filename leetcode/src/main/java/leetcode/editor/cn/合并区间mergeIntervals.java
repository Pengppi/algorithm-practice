/**
 * @Title: 56.合并区间
 * @TitleSlug: mergeIntervals
 * @Author: Neo
 * @Date: 2024-03-29 09:34:35
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 合并区间mergeIntervals {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 合并区间mergeIntervals().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            Deque<int[]> stack = new ArrayDeque<>();
            for (int[] interval : intervals) {
                int l = interval[0], r = interval[1];
                if (!stack.isEmpty() && stack.peekLast()[1] >= l) {
                    int[] p = stack.pollLast();
                    l = Math.min(p[0], l);
                    r = Math.max(p[1], r);
                }
                stack.addLast(new int[]{l, r});
            }
            return stack.toArray(new int[stack.size()][]);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
       