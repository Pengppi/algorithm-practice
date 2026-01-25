"""
Title: 3510.Minimum Pair Removal to Sort Array II
Title Slug: minimumPairRemovalToSortArrayIi
Author: Neo
Date: 2026-01-23 19:30:35
"""

from itertools import pairwise
from typing import List

from sortedcontainers import SortedList


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        pairSum = SortedList()
        ids:SortedList = SortedList(range(len(nums)))
        dec = 0
        for i,(x, y) in enumerate(pairwise(nums)):
            if x > y:
                dec += 1
            pairSum.add((x + y, i))

        ans = 0
        while dec > 0:
            ans += 1
            s, i = pairSum.pop(0)
            k = ids.bisect_left(i)
            nxt:int = ids[k+1]  # pyright: ignore[reportAssignmentType]
            if nums[i] > nums[nxt]:
                dec -= 1

            if k > 0:
                pre:int = ids[k - 1]  # pyright: ignore[reportAssignmentType]
                if nums[pre] > nums[i]:
                    dec -= 1
                if nums[pre] > s:
                    dec += 1
                pairSum.remove((nums[pre] + nums[i], pre))
                pairSum.add((nums[pre] + s, pre))

            if k + 2 < len(ids):
                nxt2:int = ids[k + 2]  # pyright: ignore[reportAssignmentType]
                if nums[nxt] > nums[nxt2]:
                    dec -= 1
                if s > nums[nxt2]:
                    dec += 1
                pairSum.remove((nums[nxt] + nums[nxt2], nxt))
                pairSum.add((s + nums[nxt2], i))

            nums[i] = s
            ids.remove(nxt)

        return ans

# leetcode submit region end(Prohibit modification and deletion)
