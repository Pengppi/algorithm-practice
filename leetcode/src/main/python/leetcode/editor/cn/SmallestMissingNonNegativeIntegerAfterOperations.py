"""
Title: 2598.Smallest Missing Non-negative Integer After Operations
Title Slug: smallestMissingNonNegativeIntegerAfterOperations
Author: Neo
Date: 2025-10-16 09:46:58
"""
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        cnt = Counter(x % value for x in nums)
        mex = 0
        m = mex % value
        while cnt[m]:
            cnt[m] -= 1
            mex += 1
            m = mex % value

        return mex

# leetcode submit region end(Prohibit modification and deletion)
