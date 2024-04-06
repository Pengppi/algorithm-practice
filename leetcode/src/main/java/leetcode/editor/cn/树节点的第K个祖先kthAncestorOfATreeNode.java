/**
 * @Title: 1483.树节点的第 K 个祖先
 * @TitleSlug: kthAncestorOfATreeNode
 * @Author: Neo
 * @Date: 2024-04-06 00:14:51
 */
package leetcode.editor.cn;

public class 树节点的第K个祖先kthAncestorOfATreeNode {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 树节点的第K个祖先kthAncestorOfATreeNode().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class TreeAncestor {
        int[][] fa;
        
        public TreeAncestor(int n, int[] parent) {
            int m = 32 - Integer.numberOfLeadingZeros(n);
            System.out.println(m);
            fa = new int[n][m];
            for (int i = 0; i < n; i++) {
                fa[i][0] = parent[i];
            }
            for (int i = 0; i < m - 1; i++) {
                for (int x = 0; x < n; x++) {
                    int p = fa[x][i];
                    fa[x][i + 1] = p == -1 ? -1 : fa[p][i];
                }
            }
        }
        
        public int getKthAncestor(int node, int k) {
            for (; k > 0; k &= k - 1) {
                if (node == -1) {
                    return -1;
                }
                node = fa[node][Integer.numberOfTrailingZeros(k)];
            }
            return node;
        }
    }

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       