/**
 * @Title: 39.组合总和
 * @TitleSlug: combinationSum
 * @Author: Neo
 * @Date: 2024-04-20 23:35:29
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 组合总和combinationSum {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 组合总和combinationSum().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> ans;
        
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ans = new ArrayList<>();
            backTracking(candidates, target, 0, new ArrayList<>());
            return ans;
        }
        
        private void backTracking(int[] candidates, int t, int x, ArrayList<Integer> list) {
            if (t <= 0) {
                if (t == 0) {
                    ans.add(new ArrayList<>(list));
                    
                }
                return;
            }
            for (int i = x; i < candidates.length; i++) {
                list.add(candidates[i]);
                backTracking(candidates, t - candidates[i], i, list);
                list.remove(list.size() - 1);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       