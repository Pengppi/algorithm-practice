# import bisect
# from bisect import bisect_left
# from functools import cache, lru_cache
# from typing import List
#
#
# class Solution:
#     def earliestTime(self, tasks: List[List[int]]) -> int:
#         return min([s + t for s, t in tasks])
#
#     def maxKDistinct(self, nums: List[int], k: int) -> List[int]:
#         selected = set()
#         nums.sort()
#         while len(selected) < k and nums:
#             selected.add(nums.pop())
#
#         return sorted(list(selected), reverse=True)
#
#
