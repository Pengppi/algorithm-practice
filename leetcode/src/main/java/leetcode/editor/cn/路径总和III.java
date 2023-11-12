/**
 * @Title: 437.路径总和 III
 * @TitleSlug: pathSumIii
 * @Author: Neo
 * @Date: 2023-11-12 12:52:06
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 路径总和III {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 路径总和III().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public int pathSum(TreeNode root, int targetSum) {
            Map<Long, Integer> mp = new HashMap<>();
            mp.put(0L, 1);
            return dfs(root, mp, 0L, targetSum);
        }

        private int dfs(TreeNode root, Map<Long, Integer> mp, long cur, int targetSum) {
            if (root == null) {
                return 0;
            }
            cur += root.val;
            int res = mp.getOrDefault(cur - targetSum, 0);
            mp.put(cur, mp.getOrDefault(cur, 0) + 1);
            res += dfs(root.left, mp, cur, targetSum);
            res += dfs(root.right, mp, cur, targetSum);
            mp.put(cur, mp.getOrDefault(cur, 0) - 1);
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       