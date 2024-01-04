/**
 * @Title: 46.全排列
 * @TitleSlug: permutations
 * @Author: Neo
 * @Date: 2024-01-04 13:02:27
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 全排列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] visted;
        List<List<Integer>> ans;

        public List<List<Integer>> permute(int[] nums) {
            int n = nums.length;
            visted = new boolean[n];
            ans = new ArrayList<>();
            dfs(nums, new ArrayList<>());
            return ans;

        }

        private void dfs(int[] nums, ArrayList<Integer> list) {
            if (list.size() == nums.length) {
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visted[i]) {
                    visted[i] = true;
                    list.add(nums[i]);
                    dfs(nums, list);
                    list.remove(list.get(list.size() - 1));
                    visted[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       