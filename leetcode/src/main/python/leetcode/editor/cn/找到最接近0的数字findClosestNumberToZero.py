"""
Title: 2239.找到最接近 0 的数字
Title Slug: findClosestNumberToZero
Author: Neo
Date: 2025-01-20 13:13:01
"""
import bisect
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        ans = nums[0]
        for x in nums:
            if abs(x) < abs(ans) or abs(x) == abs(ans) and x > ans:
                ans = x
        return ans

# leetcode submit region end(Prohibit modification and deletion)
