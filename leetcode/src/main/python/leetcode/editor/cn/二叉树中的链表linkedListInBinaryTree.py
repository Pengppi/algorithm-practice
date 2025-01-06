"""
Title: 1367.二叉树中的链表
Title Slug: linkedListInBinaryTree
Author: Neo
Date: 2024-12-30 12:26:03
"""
from typing import Optional

from leetcode.entity import ListNode, TreeNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        def find(cur, node):
            if not cur:
                return True
            if not node:
                return False
            if cur.val != node.val:
                return False
            return find(cur.next, node.left) or find(cur.next, node.right)

        def dfs(node):
            if not node:
                return False
            if find(head, node):
                return True
            return dfs(node.left) or dfs(node.right)

        return dfs(root)

# leetcode submit region end(Prohibit modification and deletion)
