"""
Title: 1022.Sum of Root To Leaf Binary Numbers
Title Slug: sumOfRootToLeafBinaryNumbers
Author: Neo
Date: 2026-02-24 16:13:46
"""

from ast import Nonlocal
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
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(path: str, node: TreeNode):
            curPath = path + str(node.val)
            if node.left:
                dfs(curPath, node.left)
            if node.right:
                dfs(curPath, node.right)
            if not node.left and not node.right:
                nonlocal ans
                ans += int(curPath, 2)

        dfs("", root)
        return ans



# leetcode submit region end(Prohibit modification and deletion)
