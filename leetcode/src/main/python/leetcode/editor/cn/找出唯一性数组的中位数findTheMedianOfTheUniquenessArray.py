"""
Title: 3134.找出唯一性数组的中位数
Title Slug: findTheMedianOfTheUniquenessArray
Author: Neo
Date: 2024-05-13 23:32:16
"""
from bisect import bisect_left
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def medianOfUniquenessArray(self, nums: List[int]) -> int:
        n = len(nums)
        k = ((n * (n + 1)) // 2 + 1) // 2

        def check(target):
            cnt = l = 0
            freq = Counter()
            for r, x in enumerate(nums):
                freq[x] += 1
                while len(freq) > target:
                    out = nums[l]
                    freq[out] -= 1
                    if freq[out] == 0:
                        del freq[out]
                    l += 1
                cnt += r - l + 1
                if cnt >= k:
                    return True
            return False
        return bisect_left(range(len(set(nums))), True, 1, key=check)

# leetcode submit region end(Prohibit modification and deletion)
