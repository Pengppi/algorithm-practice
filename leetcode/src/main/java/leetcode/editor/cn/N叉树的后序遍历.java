/**
 * @Title: 590.N 叉树的后序遍历
 * @TitleSlug: nAryTreePostorderTraversal
 * @Author: Neo
 * @Date: 2024-02-19 09:25:48
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class N叉树的后序遍历 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new N叉树的后序遍历().new Solution();
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
        public List<Integer> postorder(Node root) {
            List<Integer> ans = new ArrayList<>();
            postorder(root, ans);
            return ans;
        }
        
        private void postorder(final Node node, final List<Integer> ans) {
            if (node == null) {
                return;
            }
            if (node.children != null) {
                for (final Node child : node.children) {
                    postorder(child, ans);
                }
            }
            ans.add(node.val);
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
        
       