/**
 * @Title: 1026.节点与其祖先之间的最大差值
 * @TitleSlug: maximumDifferenceBetweenNodeAndAncestor
 * @Author: Neo
 * @Date: 2023-04-18 13:47:09
 */
package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;

public class 节点与其祖先之间的最大差值 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 节点与其祖先之间的最大差值().new Solution();
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

        private int ans = 0;

        public int maxAncestorDiff(TreeNode root) {
            dfs(root, root.val, root.val);
            return ans;
        }

        private void dfs(TreeNode root, int mn, int mx) {
            if (root == null) {
                return;
            }
            ans = Math.max(ans, Math.max(root.val - mn, mx - root.val));
            mn = Math.min(root.val, mn);
            mx = Math.max(root.val, mx);
            dfs(root.left, mn, mx);
            dfs(root.right, mn, mx);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       