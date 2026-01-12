"""
Title: 865.Smallest Subtree with all the Deepest Nodes
Title Slug: smallestSubtreeWithAllTheDeepestNodes
Author: Neo
Date: 2026-01-09 12:16:15
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

    def subtreeWithAllDeepest(self,
                              root: Optional[TreeNode]) -> Optional[TreeNode]:
        ans = root
        mxDepth = 0

        def dfs(node: TreeNode, curDepth: int) -> int:
            nonlocal ans, mxDepth
            if not node:
                mxDepth = max(mxDepth, curDepth)
                return curDepth
            left = dfs(node.left, curDepth + 1)
            right = dfs(node.right, curDepth + 1)
            if left == right == mxDepth:
                ans = node
            return max(left, right)

        dfs(root, 0)

        return ans


# leetcode submit region end(Prohibit modification and deletion)
