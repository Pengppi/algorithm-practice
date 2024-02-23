/**
 * @Title: 2583.二叉树中的第 K 大层和
 * @TitleSlug: kthLargestSumInABinaryTree
 * @Author: Neo
 * @Date: 2024-02-23 15:19:15
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class 二叉树中的第K大层和 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉树中的第K大层和().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public long kthLargestLevelSum(TreeNode root, int k) {
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Long> sums = new ArrayList<>();
            while (!queue.isEmpty()) {
                long sum = 0;
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode t = queue.poll();
                    sum += t.val;
                    if (t.left != null) {
                        queue.offer(t.left);
                    }
                    if (t.right != null) {
                        queue.offer(t.right);
                    }
                }
                sums.add(sum);
            }
            if (k > sums.size()) {
                return -1;
            }
            quickSort(sums, 0, sums.size() - 1, k - 1);
            return sums.get(k - 1);
        }
        
        private void quickSort(final List<Long> list, final int lo, final int hi, final int k) {
            if (hi <= lo) {
                return;
            }
            int j = partition(list, lo, hi);
            if (j > k) {
                quickSort(list, lo, j - 1, k);
            } else {
                quickSort(list, j + 1, hi, k);
            }
        }
        
        private int partition(final List<Long> list, final int lo, final int hi) {
            int i = lo, j = hi + 1;
            long pivot = list.get(lo);
            while (true) {
                while (list.get(++i) > pivot) {
                    if (i == hi) {
                        break;
                    }
                }
                while (list.get(--j) < pivot) {
                    if (j == lo) {
                        break;
                    }
                }
                if (i >= j) {
                    break;
                }
                long tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tmp);
            }
            list.set(lo, list.get(j));
            list.set(j, pivot);
            return j;
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
        }
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
        
       