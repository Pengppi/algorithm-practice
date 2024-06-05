"""
Title: 3072.将元素分配到两个数组中 II
Title Slug: distributeElementsIntoTwoArraysIi
Author: Neo
Date: 2024-06-05 18:31:35
"""
import bisect
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def resultArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans1, ans2 = [nums[0]], [nums[1]]
        a1, a2 = [nums[0]], [nums[1]]
        cur = 2
        while cur < n:
            i = bisect.bisect_right(a1, nums[cur])
            j = bisect.bisect_right(a2, nums[cur])
            cnt1, cnt2 = len(a1) - i, len(a2) - j
            if cnt1 > cnt2 or cnt1 == cnt2 and len(a1) <= len(a2):
                ans1.append(nums[cur])
                a1.insert(i, nums[cur])
            else:
                ans2.append(nums[cur])
                a2.insert(j, nums[cur])
            cur += 1
        return ans1 + ans2
# leetcode submit region end(Prohibit modification and deletion)
