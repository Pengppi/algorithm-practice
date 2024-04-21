/**
 * @Title: 216.组合总和 III
 * @TitleSlug: combinationSumIii
 * @Author: Neo
 * @Date: 2024-04-21 09:32:43
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 组合总和IIIcombinationSumIii {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 组合总和IIIcombinationSumIii().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> ans;
        
        public List<List<Integer>> combinationSum3(int k, int n) {
            ans = new ArrayList<>();
            backTracking(k, n, 1, new ArrayList<>());
            return ans;
        }
        
        private void backTracking(int k, int t, int x, ArrayList<Integer> list) {
            if (t < 0) {
                return;
            }
            if (k == 0) {
                if (t == 0) {
                    ans.add(new ArrayList<>(list));
                }
                return;
            }
            for (int i = x; i <= 9; i++) {
                list.add(i);
                backTracking(k - 1, t - i, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       