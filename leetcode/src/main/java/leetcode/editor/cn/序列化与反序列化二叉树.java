/**
 * @Title: LCR 156.序列化与反序列化二叉树
 * @TitleSlug: xuLieHuaErChaShuLcof
 * @Author: Neo
 * @Date: 2023-11-22 00:20:37
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 序列化与反序列化二叉树 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 序列化与反序列化二叉树().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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
        public String serialize(TreeNode root) {
            List<String> list = new ArrayList<>();
            dfs(root, list);
            return String.join(",", list);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            System.out.println(data);
            LinkedList<String> list = new LinkedList<>();
            for (String s : data.split(",")) {
                list.add(s);
            }
            return construct(list);
        }

        private TreeNode construct(LinkedList<String> list) {
            String p = list.pollFirst();
            if (p.equals("#")) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(p));
            node.left = construct(list);
            node.right = construct(list);
            return node;
        }


        private void dfs(TreeNode node, List<String> list) {
            if (node == null) {
                list.add("#");
                return;
            }
            list.add(String.valueOf(node.val));
            dfs(node.left, list);
            dfs(node.right, list);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
        
       