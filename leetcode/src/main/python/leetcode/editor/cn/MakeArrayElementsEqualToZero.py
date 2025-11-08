"""
Title: 3354.Make Array Elements Equal to Zero
Title Slug: makeArrayElementsEqualToZero
Author: Neo
Date: 2025-10-28 12:43:04
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countValidSelections(self, nums: List[int]) -> int:
        n = len(nums)

        def count(curr: int, f: int) -> int:
            t = list(nums)
            if t[curr] != 0:
                return 0
            change = curr
            while 0 <= curr <= n - 1:
                if t[curr] != 0:
                    t[curr] -= 1
                    f *= -1
                    curr, change = change - f, curr
                curr += f
            return 1 if all(x == 0 for x in t) else 0

        return sum(count(i, 1) + count(i, -1) for i, x in enumerate(nums) if x == 0)


# leetcode submit region end(Prohibit modification and deletion)
Solution().countValidSelections([1, 0, 2, 0, 3])

