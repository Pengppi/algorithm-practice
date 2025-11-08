"""
Title: 3346.Maximum Frequency of an Element After Performing Operations I
Title Slug: maximumFrequencyOfAnElementAfterPerformingOperationsI
Author: Neo
Date: 2025-10-21 12:44:59
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxFrequency(self, nums: List[int], k: int, numOperations: int) -> int:
        cnt = defaultdict(int)
        diff = defaultdict(int)
        for x in nums:
            cnt[x] += 1
            diff[x]
            diff[x - k] += 1
            diff[x + k + 1] -= 1

        ans = sumChanges = 0
        for x, d in sorted(diff.items()):
            sumChanges += d
            ans = max(ans, min(sumChanges, cnt[x] + numOperations))
        return ans
# leetcode submit region end(Prohibit modification and deletion)
