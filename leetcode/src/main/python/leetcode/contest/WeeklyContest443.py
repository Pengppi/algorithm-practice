# from typing import List
#
#
# class Solution:
#     def minCosts(self, cost: List[int]) -> List[int]:
#         mn = cost[0]
#         n = len(cost)
#         ans = [cost[0]] * n
#         for i in range(1, n):
#             mn = min(mn, cost[i])
#             ans[i] = mn
#         return ans
#
#
