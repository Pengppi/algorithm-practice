/**
 * @Title: 108.将有序数组转换为二叉搜索树
 * @TitleSlug: convertSortedArrayToBinarySearchTree
 * @Author: Neo
 * @Date: 2023-12-24 00:43:22
 */
package leetcode.editor.cn;

public class 将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 将有序数组转换为二叉搜索树().new Solution();
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildBST(nums, 0, nums.length-1);
        }

        private TreeNode buildBST(int[] nums, int l, int r) {
            if (l > r) {
                return null;
            }
            int m = l + (r - l) / 2;
            TreeNode node = new TreeNode(nums[m]);
            node.left = buildBST(nums, l, m - 1);
            node.right = buildBST(nums, m + 1, r);
            return node;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
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
        
       