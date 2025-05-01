"""
Title: 2962.统计最大元素出现至少 K 次的子数组
Title Slug: countSubarraysWhereMaxElementAppearsAtLeastKTimes
Author: Neo
Date: 2025-04-29 12:27:32
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        ans = l = cnt = 0
        mx = max(nums)
        n = len(nums)
        for r, x in enumerate(nums):
            if x == mx:
                cnt += 1
            while cnt >= k:
                ans += n - r
                if nums[l] == mx:
                    cnt -= 1
                l += 1

        return ans

# leetcode submit region end(Prohibit modification and deletion)
