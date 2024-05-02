"""
Title: 133.克隆图
Title Slug: cloneGraph
Author: Neo
Date: 2024-05-02 23:09:18
"""
from typing import Optional

from leetcode.entity import Node

# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""


class Solution:

    def __init__(self):
        self.map = {}

    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node: return None
        if node in self.map:
            return self.map[node]
        newNode = Node(node.val, [])
        self.map[node] = newNode
        newNode.neighbors = [self.cloneGraph(n) for n in node.neighbors]
        return newNode

# leetcode submit region end(Prohibit modification and deletion)
