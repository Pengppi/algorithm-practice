/**
 * @Title: 2385.感染二叉树需要的总时间
 * @TitleSlug: amountOfTimeForBinaryTreeToBeInfected
 * @Author: Neo
 * @Date: 2024-04-24 23:50:48
 */
package leetcode.editor.cn;

import entity.TreeNode;

import java.util.*;

public class 感染二叉树需要的总时间amountOfTimeForBinaryTreeToBeInfected {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 感染二叉树需要的总时间amountOfTimeForBinaryTreeToBeInfected().new Solution();
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
        private Map<Integer, List<Integer>> g;
        private Set<Integer> infected;
        
        public int amountOfTime(TreeNode root, int start) {
            g = new HashMap<>();
            infected = new HashSet<>();
            dfs(root);
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            infected.add(start);
            int ans = 0;
            while (!queue.isEmpty() && g.size() != infected.size()) {
                for (int k = queue.size(); k > 0; k--) {
                    int x = queue.poll();
                    for (int y : g.get(x)) {
                        if (infected.add(y)) {
                            queue.offer(y);
                        }
                    }
                }
                ans++;
            }
            return ans;
        }
        
        private void dfs(TreeNode node) {
            if (!g.containsKey(node.val)) {
                g.put(node.val, new ArrayList<>());
            }
            if (node.left != null) {
                put(node.val, node.left.val);
                put(node.left.val, node.val);
                dfs(node.left);
            }
            if (node.right != null) {
                put(node.val, node.right.val);
                put(node.right.val, node.val);
                dfs(node.right);
            }
        }
        
        private void put(int key, int val) {
            g.compute(key, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(val);
                return v;
            });
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
       