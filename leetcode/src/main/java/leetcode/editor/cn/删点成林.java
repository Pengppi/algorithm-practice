/**
 * @Title: 1110.删点成林
 * @TitleSlug: deleteNodesAndReturnForest
 * @Author: Neo
 * @Date: 2023-05-30 00:52:45
 */
package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.*;

public class 删点成林 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 删点成林().new Solution();
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

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> ans = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int i : to_delete) {
                set.add(i);
            }
            if (dfs(root, ans, set) != null) {
                ans.add(root);
            }
            return ans;

        }

        private TreeNode dfs(TreeNode node, List<TreeNode> ans, Set<Integer> set) {
            if (node == null) {
                return null;
            }
            node.left = dfs(node.left, ans, set);
            node.right = dfs(node.right, ans, set);
            if (!set.contains(node.val)) {
                return node;
            }
            if (node.left != null) {
                ans.add(node.left);
            }
            if (node.right != null) {
                ans.add(node.right);
            }
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       