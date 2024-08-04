"""
Title: 572.另一棵树的子树
Title Slug: subtreeOfAnotherTree
Author: Neo
Date: 2024-08-04 12:17:40
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
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def dfs(node1: TreeNode, node2: TreeNode) -> bool:
            if not node1 and not node2:
                return True
            if not node1 or not node2:
                return False
            if node1.val == node2.val:
                return dfs(node1.left, node2.left) and dfs(node1.right, node2.right)
            return False

        if not root:
            return False
        return dfs(root, subRoot) or self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

# leetcode submit region end(Prohibit modification and deletion)
