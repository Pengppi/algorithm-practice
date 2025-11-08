"""
Title: 3321.Find X-Sum of All K-Long Subarrays II
Title Slug: findXSumOfAllKLongSubarraysIi
Author: Neo
Date: 2025-11-05 12:33:47
"""
from collections import defaultdict
from typing import List

from sortedcontainers import SortedList


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        mx_list = SortedList()
        mn_list = SortedList()
        sum_mx = 0
        cnt = defaultdict(int)

        def add(val: int) -> None:
            if cnt[val] == 0:
                return
            p = (cnt[val], val)

            if mx_list and p > mx_list[0]:
                nonlocal sum_mx
                sum_mx += cnt[val] * val
                mx_list.add(p)
            else:
                mn_list.add(p)

        def remove(val: int) -> None:
            if cnt[val] == 0:
                return
            p = (cnt[val], val)
            if p in mx_list:
                nonlocal sum_mx
                sum_mx -= cnt[val] * val
                mx_list.remove(p)
            else:
                mn_list.remove(p)

        def mn2mx() -> None:
            if mn_list:
                p = mn_list.pop(-1)
                mx_list.add(p)
                nonlocal sum_mx
                sum_mx += p[0] * p[1]

        def mx2mn() -> None:
            if mx_list:
                p = mx_list.pop(0)
                mn_list.add(p)
                nonlocal sum_mx
                sum_mx -= p[0] * p[1]

        ans = [0] * (len(nums) - k + 1)
        for r, val in enumerate(nums):
            remove(val)
            cnt[val] += 1
            add(val)
            l = r - k + 1
            if l < 0:
                continue

            while mn_list and len(mx_list) < x:
                mn2mx()
            while len(mx_list) > x:
                mx2mn()

            ans[l] = sum_mx

            remove(nums[l])
            cnt[nums[l]] -= 1
            add(nums[l])

        return ans
        # leetcode submit region end(Prohibit modification and deletion)
