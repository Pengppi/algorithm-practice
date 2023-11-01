/**
 * @Title: 449.序列化和反序列化二叉搜索树
 * @TitleSlug: serializeAndDeserializeBst
 * @Author: Neo
 * @Date: 2023-09-04 23:20:48
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 序列化和反序列化二叉搜索树 {
    public static void main(String[] args) {
        //测试代码
        Codec solution = new 序列化和反序列化二叉搜索树().new Codec();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
    public class Codec {

        // Encodes a tree to a single string.
        int i = 0;
        List<String> list;

        public String serialize(TreeNode root) {
            list = new ArrayList<>();
            dfs(root);
            return String.join("-", list);
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            list.add(String.valueOf(node.val));
            dfs(node.left);
            dfs(node.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            list = Arrays.asList(data.split("-"));
            int m = Integer.MAX_VALUE / 2;
            return construct(-m, m);
        }

        private TreeNode construct(int l, int r) {
            if (i == list.size()) {
                return null;
            }
            int x = Integer.parseInt(list.get(i));
            if (x < l || x > r) {
                return null;
            }
            i++;
            TreeNode node = new TreeNode(x);
            node.left = construct( l, x);
            node.right = construct( x, r);
            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}
        
       