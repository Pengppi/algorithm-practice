"""
Title: 2389.和有限的最长子序列
Title Slug: longestSubsequenceWithLimitedSum
Author: Neo
Date: 2025-03-24 12:33:48
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        nums.sort()
        m = len(queries)
        ans = [0] * m
        idx = sorted(range(m), key=lambda x: queries[x])

        j = 0
        cur = 0
        for i in idx:
            while j < len(nums) and cur <= queries[i]:
                cur += nums[j]
                j += 1
            ans[i] = j - 1 if cur > queries[i] else j
        return ans

    # leetcode submit region end(Prohibit modification and deletion)
