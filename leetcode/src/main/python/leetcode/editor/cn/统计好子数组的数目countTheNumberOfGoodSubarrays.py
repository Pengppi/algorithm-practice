"""
Title: 2537.统计好子数组的数目
Title Slug: countTheNumberOfGoodSubarrays
Author: Neo
Date: 2025-04-16 11:19:54
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countGood(self, nums: List[int], k: int) -> int:
        n = len(nums)
        ans = 0
        l = 0
        cnt = defaultdict(int)
        pair = 0
        for r, x in enumerate(nums):
            pair += cnt[x]
            cnt[x] += 1
            while pair >= k:
                ans += n - r
                cnt[nums[l]] -= 1
                pair -= cnt[nums[l]]
                l += 1
        return ans

        # leetcode submit region end(Prohibit modification and deletion)
