/**
 * @Title: 331.验证二叉树的前序序列化
 * @TitleSlug: verifyPreorderSerializationOfABinaryTree
 * @Author: Neo
 * @Date: 2024-03-31 00:10:14
 */
package leetcode.editor.cn;

public class 验证二叉树的前序序列化verifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 验证二叉树的前序序列化verifyPreorderSerializationOfABinaryTree().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSerialization(String preorder) {
            String[] ss = preorder.split(",");
            int res = dfs(ss, 0);
            return res == ss.length - 1;
        }
        
        private int dfs(String[] ss, int i) {
            if (i >= ss.length) {
                return -1;
            }
            if (ss[i].equals("#")) {
                return i;
            }
            int left = dfs(ss, i + 1);
            if (left == -1) {
                return -1;
            }
            return dfs(ss, left + 1);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       