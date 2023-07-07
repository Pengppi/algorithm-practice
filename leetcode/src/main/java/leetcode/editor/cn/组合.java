/**
 * @Title: 77.组合
 * @TitleSlug: Combinations
 * @Author: Neo
 * @Date: 2022-10-21 00:46:50
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 组合 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 组合().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans;

        public List<List<Integer>> combine(int n, int k) {
            ans = new ArrayList<>();
            dfs(n, k, 1, new ArrayList<>());
            return ans;
        }

        private void dfs(int n, int k, int i, ArrayList<Integer> list) {
            if (list.size() == k) {
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int j = i; j <= n; j++) {
                list.add(j);
                dfs(n, k, j + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
