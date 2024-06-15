"""
Title: LCR 044.在每个树行中找最大值
Title Slug: hPov7L
Author: Neo
Date: 2024-06-15 12:32:10
"""
from cmath import inf
from typing import List

from leetcode.entity import TreeNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        queue = [root]
        ans = []
        while queue:
            sz = len(queue)
            mx = -inf
            for i in range(sz):
                node = queue.pop(0)
                mx = max(mx, node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            ans.append(mx)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
