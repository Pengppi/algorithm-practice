"""
Title: 1339.Maximum Product of Splitted Binary Tree
Title Slug: maximumProductOfSplittedBinaryTree
Author: Neo
Date: 2026-01-08 23:42:46
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

    def maxProduct(self, root: Optional[TreeNode]) -> int:
        mod = 10**9 + 7
        nodeSums = []

        def collectSums(node: TreeNode) -> int:

            res = node.val
            if node.left:
                res += collectSums(node.left)
            if node.right:
                res += collectSums(node.right)
            nodeSums.append(res)
            return res

        tot = collectSums(root)
        ans = 0
        for i in range(len(nodeSums) - 1):
            x = nodeSums[i]
            y = tot - x
            ans = max(ans, x * y)
        return ans % mod


# leetcode submit region end(Prohibit modification and deletion)
