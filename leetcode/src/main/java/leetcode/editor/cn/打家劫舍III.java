/**
 * @Title: 337.打家劫舍 III
 * @TitleSlug: houseRobberIii
 * @Author: Neo
 * @Date: 2023-09-18 23:34:22
 */
package leetcode.editor.cn;

public class 打家劫舍III {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 打家劫舍III().new Solution();
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
        public int rob(TreeNode root) {
            int[] rootStatus = dfs(root);
            return Math.max(rootStatus[0], rootStatus[1]);
        }

        private int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            int selected = root.val + left[0] + right[0];
            int notSelect = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return new int[]{notSelect, selected};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       