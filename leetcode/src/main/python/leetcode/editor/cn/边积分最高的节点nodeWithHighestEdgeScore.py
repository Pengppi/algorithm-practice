"""
Title: 2374.边积分最高的节点
Title Slug: nodeWithHighestEdgeScore
Author: Neo
Date: 2024-09-21 12:31:30
"""
from collections import Counter, defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def edgeScore(self, edges: List[int]) -> int:
        mp = defaultdict(int)
        ans = 0
        for i, x in enumerate(edges):
            mp[x] += i
            if mp[x] > mp[ans] or mp[x] == mp[ans] and x < ans:
                ans = x
        return ans
# leetcode submit region end(Prohibit modification and deletion)
