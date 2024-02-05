/**
 * @Title: 39.组合总和
 * @TitleSlug: combinationSum
 * @Author: Neo
 * @Date: 2024-02-04 18:02:34
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 组合总和().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        private List<List<Integer>> ans = new ArrayList<>();
        private int[] candidates;
        private int target;
        
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            this.target = target;
            dfs(0, 0, new ArrayList<>());
            return ans;
        }
        
        private void dfs(final int x, int sum, final List<Integer> cur) {
            if (sum == target) {
                ans.add(new ArrayList<>(cur));
                return;
            } else if (sum > target) {
                return;
            }
            for (int i = x; i < candidates.length; i++) {
                cur.add(candidates[i]);
                sum += candidates[i];
                dfs(i, sum, cur);
                sum -= candidates[i];
                cur.remove(cur.size() - 1);
            }
            
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       