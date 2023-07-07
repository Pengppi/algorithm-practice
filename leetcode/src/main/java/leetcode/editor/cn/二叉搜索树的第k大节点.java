/**
 * @Title: 剑指 Offer 54.二叉搜索树的第k大节点
 * @TitleSlug: erChaSouSuoShuDeDiKdaJieDianLcof
 * @Author: Neo
 * @Date: 2023-05-25 11:13:54
 */
package leetcode.editor.cn;

public class 二叉搜索树的第k大节点 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉搜索树的第k大节点().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int res = -1, cnt = 0, k;

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null || cnt == k) {
                return;
            }
            dfs(root.right);
            cnt++;
            if (cnt == k) {
                res = root.val;
                return;
            }
            dfs(root.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       