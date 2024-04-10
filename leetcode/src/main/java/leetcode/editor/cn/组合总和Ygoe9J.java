/**
 * @Title: LCR 081.组合总和
 * @TitleSlug: Ygoe9J
 * @Author: Neo
 * @Date: 2024-04-10 14:12:22
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和Ygoe9J {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 组合总和Ygoe9J().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> ans;
        private int[] candidates;
        
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ans = new ArrayList<>();
            Arrays.sort(candidates);
            this.candidates = candidates;
            dfs(0, target, new ArrayList<>());
            return ans;
        }
        
        private void dfs(int x, int k, List<Integer> list) {
            if (k == 0) {
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int i = x; i < candidates.length; i++) {
                if (candidates[i] <= k) {
                    list.add(candidates[i]);
                    dfs(i, k - candidates[i], list);
                    list.remove(list.size() - 1);
                } else {
                    break;
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       