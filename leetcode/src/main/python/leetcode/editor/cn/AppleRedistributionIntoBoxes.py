"""
Title: 3074.Apple Redistribution into Boxes
Title Slug: appleRedistributionIntoBoxes
Author: Neo
Date: 2025-12-24 10:17:34
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        tot = sum(apple)
        ans = 0
        capacity.sort(reverse=True)
        for x in capacity:
            ans += 1
            tot -= x
            if tot <= 0:
                break
        return ans


# leetcode submit region end(Prohibit modification and deletion)
