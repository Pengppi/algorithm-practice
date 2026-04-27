"""
Title: 2833.Furthest Point From Origin
Title Slug: furthestPointFromOrigin
Author: Neo
Date: 2026-04-24 15:11:31
"""
from collections import Counter


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        cnt = Counter(moves)
        return abs(cnt['L'] - cnt['R']) + cnt['_']
# leetcode submit region end(Prohibit modification and deletion)

