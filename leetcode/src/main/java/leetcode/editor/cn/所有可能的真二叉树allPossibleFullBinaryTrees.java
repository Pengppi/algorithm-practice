/**
 * @Title: 894.所有可能的真二叉树
 * @TitleSlug: allPossibleFullBinaryTrees
 * @Author: Neo
 * @Date: 2024-04-02 00:53:01
 */
package leetcode.editor.cn;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 所有可能的真二叉树allPossibleFullBinaryTrees {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 所有可能的真二叉树allPossibleFullBinaryTrees().new Solution();
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
        private Map<Integer, List<TreeNode>> map = new HashMap<>();
        
        public List<TreeNode> allPossibleFBT(int n) {
            if (map.containsKey(n)) {
                return map.get(n);
            }
            List<TreeNode> ans = new ArrayList<>();
            if ((n & 1) != 1) {
                return ans;
            }
            if (n == 1) {
                ans.add(new TreeNode(0));
                return ans;
            }
            n = n - 1;// 子节点个数和为偶数
            for (int i = 1; i < n; i += 2) {
                var lList = allPossibleFBT(i);
                var rList = allPossibleFBT(n - i);
                for (TreeNode l : lList) {
                    for (TreeNode r : rList) {
                        ans.add(new TreeNode(0, l, r));
                    }
                }
            }
            map.put(n, ans);
            return ans;
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       