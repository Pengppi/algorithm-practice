"""
Title: 1262.Greatest Sum Divisible by Three
Title Slug: greatestSumDivisibleByThree
Author: Neo
Date: 2025-08-17 17:04:17
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        tot = sum(nums)
        r = tot % 3
        if r == 0:
            return tot
        nums.sort()
        a1 = [x for x in nums if x % 3 == 1]
        a2 = [x for x in nums if x % 3 == 2]
        if r == 2:
            a1, a2 = a2, a1
        ans = tot - a1[0] if a1 else 0
        if len(a2) > 1:
            ans = max(ans, tot - a2[0] - a2[1])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
Solution().maxSumDivThree([1,1,3])