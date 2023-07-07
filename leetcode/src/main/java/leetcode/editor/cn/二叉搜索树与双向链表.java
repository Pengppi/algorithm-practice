/**
 * @Title: 剑指 Offer 36.二叉搜索树与双向链表
 * @TitleSlug: erChaSouSuoShuYuShuangXiangLianBiaoLcof
 * @Author: Neo
 * @Date: 2023-05-22 22:02:51
 */
package leetcode.editor.cn;

public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉搜索树与双向链表().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {
        Node pre;
        Node head;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        private void dfs(Node root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                dfs(root.left);
            }
            if (pre == null) {
                head = root;
                pre = root;
            } else {
                pre.right = root;
                root.left = pre;
                pre = root;
            }
            if (root.right != null) {
                dfs(root.right);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       