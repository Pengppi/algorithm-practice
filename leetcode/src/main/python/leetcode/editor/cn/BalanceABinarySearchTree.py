"""
Title: 1382.Balance a Binary Search Tree
Title Slug: balanceABinarySearchTree
Author: Neo
Date: 2026-02-09 12:28:38
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
    def balanceBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        arr = []

        def buildArr(node: TreeNode) -> None:
            if not node:
                return
            buildArr(node.left)
            arr.append(node)
            buildArr(node.right)
            node.left = None
            node.right = None

        def buildTree(start: int, end: int) -> Optional[TreeNode]:
            if start > end:
                return None
            mid = (start + end) // 2
            rt = arr[mid]
            rt.left = buildTree(start, mid - 1)
            rt.right = buildTree(mid + 1, end)
            return rt


        buildArr(root)
        return buildTree(0, len(arr) - 1)

# leetcode submit region end(Prohibit modification and deletion)
