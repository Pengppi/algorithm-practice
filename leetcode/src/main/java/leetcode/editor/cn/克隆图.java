/**
 * @Title: 133.克隆图
 * @TitleSlug: cloneGraph
 * @Author: Neo
 * @Date: 2024-01-17 15:26:09
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 克隆图 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 克隆图().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
    
    class Solution {
        private final Map<Integer, Node> map = new HashMap<>();
        
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            if (map.containsKey(node.val)) {
                return map.get(node.val);
            }
            Node newNode = new Node(node.val);
            map.put(node.val, newNode);
            for (final Node neighbor : node.neighbors) {
                newNode.neighbors.add(cloneGraph(neighbor));
            }
            return newNode;
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
    class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
        
       