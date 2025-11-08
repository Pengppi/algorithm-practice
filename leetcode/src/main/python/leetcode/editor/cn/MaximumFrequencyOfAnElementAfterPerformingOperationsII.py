"""
Title: 3347.Maximum Frequency of an Element After Performing Operations II
Title Slug: maximumFrequencyOfAnElementAfterPerformingOperationsIi
Author: Neo
Date: 2025-10-22 21:38:16
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

        cur_cnt = 0
        ans = 0
        for x, d in sorted(diff.items()):
            cur_cnt += d
            ans = max(ans, min(cur_cnt, cnt[x] + numOperations))
        return ans

# leetcode submit region end(Prohibit modification and deletion)
