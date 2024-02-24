/**
 * @Title: 2476.二叉搜索树最近节点查询
 * @TitleSlug: closestNodesQueriesInABinarySearchTree
 * @Author: Neo
 * @Date: 2024-02-24 09:48:13
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树最近节点查询 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉搜索树最近节点查询().new Solution();
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
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            List<Integer> values = new ArrayList<>();
            getTreeValues(root, values);
            int n = values.size();
            int[] arr = values.stream().mapToInt(Integer::intValue).toArray();
            List<List<Integer>> ans = new ArrayList<>(queries.size());
            for (int query : queries) {
                int j = lower_bound(arr, query);
                int mx = j == n ? -1 : arr[j];
                if (j == n || arr[j] != query) {
                    j--;
                }
                int mn = j < 0 ? -1 : arr[j];
                ans.add(List.of(mn, mx));
            }
            return ans;
        }
        
        private int lower_bound(int[] arr, int t) {
            int l = -1, r = arr.length;
            while (l + 1 < r) {
                int m = (l + r) >> 1;
                if (arr[m] < t) {
                    l = m;
                } else {
                    r = m;
                }
            }
            return r;
        }
        
        private void getTreeValues(final TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            getTreeValues(root.left, list);
            list.add(root.val);
            getTreeValues(root.right, list);
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
        
       