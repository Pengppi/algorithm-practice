/**
 * @Title: 1130.叶值的最小代价生成树
 * @TitleSlug: minimumCostTreeFromLeafValues
 * @Author: Neo
 * @Date: 2023-05-31 14:42:58
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 叶值的最小代价生成树 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 叶值的最小代价生成树().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            int ans = 0;
            Deque<Integer> d = new ArrayDeque<>();
            for (int x : arr) {
                while (!d.isEmpty() && d.peekLast() <= x) {
                    int cur = d.pollLast();
                    if (d.isEmpty() || d.peekLast() > x) {
                        ans += cur * x;
                    } else {
                        ans += cur * d.peekLast();
                    }
                }
                d.addLast(x);
            }
            while (d.size() > 1) {
                ans += d.pollLast() * d.peekLast();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       