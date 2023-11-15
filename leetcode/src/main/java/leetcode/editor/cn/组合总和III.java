/**
 * @Title: 216.组合总和 III
 * @TitleSlug: combinationSumIii
 * @Author: Neo
 * @Date: 2023-11-16 00:21:44
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 组合总和III().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans;

        public List<List<Integer>> combinationSum3(int k, int n) {
            int[] used = new int[10];
            for (int i = 1; i <= 9; i++) {
                used[i] = 1;
            }
            ans = new ArrayList<>();
            dfs(used, 1, k, n, new ArrayList<>());
            return ans;
        }

        private void dfs(int[] used, int x, int k, int n, List<Integer> list) {
            if (k == 0) {
                if (n == 0) {
                    ans.add(new ArrayList<>(list));
                }
                return;
            }
            if (n < 0) {
                return;
            }
            for (int i = x; i <= 9; i++) {
                if (used[i] == 1) {
                    list.add(i);
                    used[i] = 0;
                    dfs(used, i+1, k - 1, n - i, list);
                    used[i] = 1;
                    list.remove(list.get(list.size() - 1));
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       