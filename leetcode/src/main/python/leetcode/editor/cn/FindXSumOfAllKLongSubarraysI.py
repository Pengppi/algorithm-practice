"""
Title: 3318.Find X-Sum of All K-Long Subarrays I
Title Slug: findXSumOfAllKLongSubarraysI
Author: Neo
Date: 2025-11-04 12:26:33
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        cnt = defaultdict(int)
        ans = []
        for i, num in enumerate(nums):
            cnt[num] += 1
            if i >= k:
                cnt[nums[i - k]] -= 1
            if i >= k - 1:
                s = 0
                for j, (ke, va) in enumerate(sorted(cnt.items(), key=lambda o: (-o[1], -o[0]))):
                    if j >= x:
                        break
                    s += ke * va
                ans.append(s)

        return ans
# leetcode submit region end(Prohibit modification and deletion)
