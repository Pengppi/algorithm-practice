"""
Title: 110.Balanced Binary Tree
Title Slug: balancedBinaryTree
Author: Neo
Date: 2026-02-08 16:56:01
"""

from typing import Optional

from leetcode.entity import TreeNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        def dfs(node: TreeNode) -> int:
            if not node:
                return 0
            left = dfs(node.left)  # pyright: ignore[reportArgumentType]
            right = dfs(node.right)  # pyright: ignore[reportArgumentType]

            mn, mx = min(left, right), max(left, right)

            if mn == -1 or mx - mn > 1:
                return -1

            return mx + 1

        return dfs(root) != -1  # pyright: ignore[reportArgumentType]


# leetcode submit region end(Prohibit modification and deletion)
