/**
 * @Title: 剑指 Offer 34.二叉树中和为某一值的路径
 * @TitleSlug: erChaShuZhongHeWeiMouYiZhiDeLuJingLcof
 * @Author: Neo
 * @Date: 2023-07-07 17:24:18
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉树中和为某一值的路径().new Solution();
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

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null) {
                return ans;
            }
            dfs(root, target, new ArrayList<>());
            return ans;
        }

        private void dfs(TreeNode node, int target, List<Integer> list) {
            list.add(node.val);
            if (node.left != null) {
                dfs(node.left, target - node.val, list);
            }
            if (node.right != null) {
                dfs(node.right, target - node.val, list);
            }
            if (node.left == null && node.right == null) {
                if (target == node.val) {
                    ans.add(new ArrayList<>(list));
                }
            }
            list.remove(list.size() - 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       