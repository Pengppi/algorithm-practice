/**
 * @Title: LCR 079.子集
 * @TitleSlug: TVdhkn
 * @Author: Neo
 * @Date: 2024-03-12 09:17:09
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 子集TVdhkn {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 子集TVdhkn().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, nums, 0, new ArrayList<>());
            return ans;
        }
        
        private void dfs(List<List<Integer>> ans, int[] nums, int x, ArrayList<Integer> list) {
            ans.add(new ArrayList<>(list));
            
            for (int i = x; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(ans, nums, i + 1, list);
                list.remove(list.get(list.size() - 1));
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       