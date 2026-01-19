"""
Title: 2975.Maximum Square Area by Removing Fences From a Field
Title Slug: maximumSquareAreaByRemovingFencesFromAField
Author: Neo
Date: 2026-01-16 12:52:13
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def maximizeSquareArea(
        self, m: int, n: int, hFences: List[int], vFences: List[int]
    ) -> int:
        mod = 10**9 + 7
        hs = set()
        hs.add(m - 1)
        for i, x in enumerate(hFences):
            hs.add(x - 1)
            hs.add(m - x)
            for j in range(i):
                hs.add(abs(x - hFences[j]))

        if n - 1 in hs:
            return (n - 1) ** 2 % mod

        ans = -1
        for i, y in enumerate(vFences):
            if y - 1 in hs:
                ans = max(ans, y - 1)
            if n - y in hs:
                ans = max(ans, n - y)
            for j in range(i):
                if abs(y - vFences[j]) in hs:
                    ans = max(ans, abs(y - vFences[j]))

        return ans**2 % mod if ans != -1 else -1


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maximizeSquareArea(6, 7, [2], [4]))
