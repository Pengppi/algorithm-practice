"""
Title: 3287.求出数组中最大序列值
Title Slug: findTheMaximumSequenceValueOfArray
Author: Neo
Date: 2025-01-18 11:16:44
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxValue(self, nums: List[int], k: int) -> int:
        def getOr(arr):
            dp = []
            prev = [set() for _ in range(k + 1)]
            prev[0].add(0)
            for i, num in enumerate(arr):
                for j in range(min(k - 1, i + 1), -1, -1):
                    for x in prev[j]:
                        prev[j + 1].add(x | num)
                dp.append(prev[k].copy())
            return dp

        l = getOr(nums)
        r = getOr(nums[::-1])
        ans = 0
        for i in range(k - 1, len(nums) - k):
            ans = max(ans, *(a ^ b for a in l[i] for b in r[-(i + 2)]))

        return ans

# leetcode submit region end(Prohibit modification and deletion)
