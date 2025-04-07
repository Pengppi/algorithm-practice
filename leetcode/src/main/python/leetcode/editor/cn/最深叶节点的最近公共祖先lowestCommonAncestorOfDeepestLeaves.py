"""
Title: 1123.最深叶节点的最近公共祖先
Title Slug: lowestCommonAncestorOfDeepestLeaves
Author: Neo
Date: 2025-04-04 12:59:41
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
    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        ans = None
        mx_dep = 0

        def dfs(node, depth):
            nonlocal mx_dep
            if not node:
                mx_dep = max(mx_dep, depth)
                return depth
            l = dfs(node.left, depth + 1)
            r = dfs(node.right, depth + 1)

            if l == r == mx_dep:
                nonlocal ans
                ans = node
            return max(l, r)

        dfs(root, 0)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
