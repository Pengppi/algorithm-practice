/**
 * @Title: 1483.树节点的第 K 个祖先
 * @TitleSlug: kthAncestorOfATreeNode
 * @Author: Neo
 * @Date: 2023-06-12 15:22:46
 */
package leetcode.editor.cn;

public class 树节点的第K个祖先 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 树节点的第K个祖先().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TreeAncestor {
        int[][] pa;

        public TreeAncestor(int n, int[] parent) {
            int m = 32 - Integer.numberOfLeadingZeros(n);
            pa = new int[n][m];
            for (int i = 0; i < n; i++) {
                pa[i][0] = parent[i];
            }
            for (int i = 0; i < m-1; i++) {
                for (int x = 0; x < n; x++) {
                    int p = pa[x][i];
                    pa[x][i + 1] = p == -1 ? -1 : pa[p][i];
                }
            }

        }

        public int getKthAncestor(int node, int k) {
            int m = 32 - Integer.numberOfLeadingZeros(k);
            for (int i = 0; i < m; i++) {
                if ((1 & (k >> i)) > 0) {
                    node = pa[node][i];
                    if (node == -1) {
                        break;
                    }
                }
            }
            return node;
        }
    }

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       