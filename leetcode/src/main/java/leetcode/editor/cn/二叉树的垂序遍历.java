/**
 * @Title: 987.二叉树的垂序遍历
 * @TitleSlug: verticalOrderTraversalOfABinaryTree
 * @Author: Neo
 * @Date: 2024-02-13 10:22:15
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 二叉树的垂序遍历 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉树的垂序遍历().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    
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
        private int minCol = 0;
        
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            Map<Integer, List<int[]>> mapByCol = new HashMap<>();
            dfs(root, 0, 0, mapByCol);
            List<List<Integer>> ans = new ArrayList<>();
            for (int c = minCol; c < minCol + mapByCol.size(); c++) {
                ans.add(mapByCol.get(c).stream().
                        sorted((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1])
                        .map(e->e[0]).collect(Collectors.toList()));
                
            }
            return ans;
        }
        
        private void dfs(final TreeNode node, final int r, final int c, final Map<Integer, List<int[]>> mapByCol) {
            if (node == null) {
                return;
            }
            minCol = Math.min(minCol, c);
            mapByCol.computeIfAbsent(c, e -> new ArrayList<>()).add(new int[]{node.val, r});
            dfs(node.left, r + 1, c - 1, mapByCol);
            dfs(node.right, r + 1, c + 1, mapByCol);
        }
        
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
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
}
        
       