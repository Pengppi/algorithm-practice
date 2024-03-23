/**
 * @Title: 2549.统计桌面上的不同数字
 * @TitleSlug: countDistinctNumbersOnBoard
 * @Author: Neo
 * @Date: 2024-03-23 17:30:09
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class 统计桌面上的不同数字countDistinctNumbersOnBoard {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 统计桌面上的不同数字countDistinctNumbersOnBoard().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distinctIntegers(int n) {
            Deque<Integer> queue = new ArrayDeque<>();
            Set<Integer> set = new HashSet<>();
            queue.add(n);
            set.add(n);
            for (int k = 0; k < 1e9 && !queue.isEmpty(); k++) {
                for (int i = queue.size(); i > 0; i--) {
                    int x = queue.poll();
                    for (int j = 1; j <= n; j++) {
                        if (!set.contains(j) && x % j == 1) {
                            set.add(j);
                            queue.offer(j);
                        }
                    }
                }
            }
            return set.size();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       