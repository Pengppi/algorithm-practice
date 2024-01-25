/**
 * @Title: 427.建立四叉树
 * @TitleSlug: constructQuadTree
 * @Author: Neo
 * @Date: 2024-01-25 09:32:54
 */
package leetcode.editor.cn;

public class 建立四叉树 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 建立四叉树().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/
    
    class Solution {
        public Node construct(int[][] grid) {
            return buildTree(grid, 0, 0, grid.length - 1, grid.length - 1);
        }
        
        private Node buildTree(final int[][] grid, final int a, final int b, final int c, final int d) {
            boolean isSame = true;
            for (int i = a; i <= c; i++) {
                for (int j = b; j <= d; j++) {
                    if (grid[i][j] != grid[a][b]) {
                        isSame = false;
                        break;
                    }
                }
            }
            if (isSame) {
                return new Node(grid[a][b] == 1, true);
            } else {
                Node root = new Node(grid[a][b] == 1, false);
                int mx = a + (c - a) / 2;
                int my = b + (d - b) / 2;
                root.topLeft = buildTree(grid, a, b, mx, my);
                root.topRight = buildTree(grid, a, my + 1, mx, d);
                root.bottomLeft = buildTree(grid, mx + 1, b, c, my);
                root.bottomRight = buildTree(grid, mx+1, my + 1, c, d);
                return root;
            }
        }
        
        
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
        
        
        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
        
       