"""
Title: 100.相同的树
Title Slug: sameTree
Author: Neo
Date: 2024-05-03 00:33:42
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
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if p and q:
            return (self.isSameTree(p.left, q.left)
                    and self.isSameTree(p.right, q.right)) if p.val == q.val else False
        elif not p and not q:
            return True
        else:
            return False
# leetcode submit region end(Prohibit modification and deletion)
