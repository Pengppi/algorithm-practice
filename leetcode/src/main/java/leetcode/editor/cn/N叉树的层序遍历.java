/**
 * @Title: 429.N 叉树的层序遍历
 * @TitleSlug: nAryTreeLevelOrderTraversal
 * @Author: Neo
 * @Date: 2024-02-17 19:40:03
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class N叉树的层序遍历 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new N叉树的层序遍历().new Solution();
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
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                for (int i = queue.size(); i > 0; i--) {
                    Node node = queue.poll();
                    list.add(node.val);
                    if (node.children != null) {
                        for (Node child : node.children) {
                            queue.offer(child);
                        }
                    }
                }
                ans.add(list);
            }
            return ans;
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
        
       