"""
Title: 2488.Count Subarrays With Median K
Title Slug: countSubarraysWithMedianK
Author: Neo
Date: 2025-10-03 23:30:55
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        pos = nums.index(k)
        cnt = defaultdict(int)
        cnt[0] = 1
        x = 0
        for i in range(pos - 1, -1, -1):
            x += 1 if nums[i] < k else -1
            cnt[x] += 1

        ans = cnt[0] + cnt[-1]
        x = 0
        for i in range(pos + 1, len(nums)):
            x += 1 if nums[i] > k else -1
            ans += cnt[x] + cnt[x - 1]
        return ans

# leetcode submit region end(Prohibit modification and deletion)
