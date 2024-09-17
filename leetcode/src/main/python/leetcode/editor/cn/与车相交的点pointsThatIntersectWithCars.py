"""
Title: 2848.与车相交的点
Title Slug: pointsThatIntersectWithCars
Author: Neo
Date: 2024-09-15 13:16:33
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfPoints(self, nums: List[List[int]]) -> int:
        nums.sort(key=lambda x: x[0])
        ans = 0
        last = -1
        for l, r in nums:
            if l > last:
                ans += r - l + 1
            elif r > last:
                ans += r - last
            last = max(last, r)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
