"""
Title: 1161.Maximum Level Sum of a Binary Tree
Title Slug: maximumLevelSumOfABinaryTree
Author: Neo
Date: 2026-01-06 16:56:38
"""
from collections import deque
from math import inf
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

    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        ans = 1
        mx = -inf
        q = deque()
        q.append(root)
        i = 1
        while q:
            s = 0
            for _ in range(len(q) - 1, -1, -1):
                node = q.popleft()
                s += node.val
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            if s > mx:
                mx = s
                ans = i
            i += 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
