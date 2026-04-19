"""
Title: 3488.Closest Equal Element Queries
Title Slug: closestEqualElementQueries
Author: Neo
Date: 2026-04-16 12:32:58
"""

from bisect import bisect_left
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def solveQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        n = len(nums)
        mp = defaultdict(list)
        for i, x in enumerate(nums):
            mp[x].append(i)
        ans = [-1] * len(queries)
        for i, idx in enumerate(queries):
            arr = mp[nums[idx]]
            if len(arr) <= 1:
                continue
            k = bisect_left(arr, idx)
            longest = max(arr[k] - arr[0], arr[-1] - arr[k])
            if k == 0:
                shortest = arr[1] - arr[0]
            elif k == len(arr) - 1:
                shortest = arr[-1] - arr[-2]
            else:
                shortest = min(arr[k + 1] - arr[k], arr[k] - arr[k - 1])

            ans[i] = min(n - longest, shortest)

        return ans

# leetcode submit region end(Prohibit modification and deletion)
