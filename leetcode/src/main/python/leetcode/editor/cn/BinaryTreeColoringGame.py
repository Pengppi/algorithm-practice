"""
Title: 1145.Binary Tree Coloring Game
Title Slug: binaryTreeColoringGame
Author: Neo
Date: 2026-04-12 13:06:53
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
    def btreeGameWinningMove(self, root: Optional[TreeNode], n: int, x: int) -> bool:

        xLeft = 0
        xRight = 0

        def dfs(node: Optional[TreeNode]) -> int:
            if not node:
                return 0
            left = dfs(node.left)
            right = dfs(node.right)
            if node.val == x:
                nonlocal xLeft, xRight
                xLeft = left
                xRight = right

            return left + right + 1

        dfs(root)
        mx = max(xLeft, xRight)
        if 2 * mx > n:
            return True
        other = n - (xLeft + xRight + 1)
        return 2 * other > n


# leetcode submit region end(Prohibit modification and deletion)
