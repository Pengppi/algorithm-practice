"""
Title: 1007.行相等的最少多米诺旋转
Title Slug: minimumDominoRotationsForEqualRow
Author: Neo
Date: 2025-05-03 21:50:17
"""
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        def count(t: int):
            cnt1 = cnt2 = 0
            for x, y in zip(tops, bottoms):
                if x != t and y != t:
                    return inf
                if x != t:
                    cnt1 += 1
                elif y != t:
                    cnt2 += 1
            return min(cnt1, cnt2)

        ans = min(count(tops[0]), count(bottoms[0]))
        return ans if ans < inf else -1

    # leetcode submit region end(Prohibit modification and deletion)
