/**
 * @Title: 589.N 叉树的前序遍历
 * @TitleSlug: nAryTreePreorderTraversal
 * @Author: Neo
 * @Date: 2024-02-18 09:29:14
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class N叉树的前序遍历 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new N叉树的前序遍历().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
    
    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> ans = new ArrayList<>();
            dfs(root, ans);
            return ans;
        }
        
        private void dfs(final Node node, final List<Integer> ans) {
            if (node == null) {
                return;
            }
            ans.add(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    dfs(child, ans);
                }
            }
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
    class Node {
        public int val;
        public List<Node> children;
        
        public Node() {
        }
        
        public Node(int _val) {
            val = _val;
        }
        
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
        
       