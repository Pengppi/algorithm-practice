/**
 * @Title: 386.字典序排数
 * @TitleSlug: lexicographicalNumbers
 * @Author: Neo
 * @Date: 2024-04-29 15:33:28
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class 字典序排数lexicographicalNumbers {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 字典序排数lexicographicalNumbers().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> ans = new ArrayList<>();
            IntStream.rangeClosed(1, 9).forEach(i -> dfs(i, n, ans));
            return ans;
        }
        
        private void dfs(int cur, int limit, List<Integer> ans) {
            if (cur <= limit) {
                ans.add(cur);
                IntStream.rangeClosed(0, 9).forEach(i -> dfs(cur * 10 + i, limit, ans));
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       