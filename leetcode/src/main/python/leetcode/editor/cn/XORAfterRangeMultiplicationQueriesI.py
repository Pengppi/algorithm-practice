"""
Title: 3653.XOR After Range Multiplication Queries I
Title Slug: xorAfterRangeMultiplicationQueriesI
Author: Neo
Date: 2026-04-08 09:39:37
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def xorAfterQueries(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)
        mod = 10**9 + 7
        for i,r,k,v in queries:
            while i <= r:
                nums[i] = (nums[i] * v) % mod
                i += k
        ans = 0
        for c in nums:
            ans ^= c
        return ans

# leetcode submit region end(Prohibit modification and deletion)
