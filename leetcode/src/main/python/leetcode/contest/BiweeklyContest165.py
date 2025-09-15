# from collections import defaultdict
# from typing import List
#
#
# class Solution:
#     def smallestAbsent(self, nums: List[int]) -> int:
#         n = len(nums)
#         st = set(nums)
#         ans = max(sum(nums) // n, 0) + 1
#         while ans in st:
#             ans += 1
#         return ans
#
#     def minArrivalsToDiscard(self, arrivals: List[int], w: int, m: int) -> int:
#         ans = 0
#         wc = defaultdict(int)
#         skip = set()
#         for i, x in enumerate(arrivals):
#             if i >= w and (i - w) not in skip:
#                 rm = arrivals[i - w]
#                 if wc[rm] > 0:
#                     wc[rm] -= 1
#             if wc[x] == m:
#                 skip.add(i)
#                 ans += 1
#             else:
#                 wc[x] += 1
#
#         return ans
#
#     def generateSchedule(self, n: int) -> List[List[int]]:
#         if n <= 3:
#             return []
#         if n == 5:
#             return [[0, 1], [2, 3], [0, 4], [1, 2], [3, 4], [0, 2], [1, 3], [2, 4], [0, 3], [1, 4], [2, 0], [3, 1], [4, 0], [2, 1], [4, 3], [1, 0], [3, 2],
#                     [4, 1], [3, 0], [4, 2]]
#
#         matches = []
#         for i in range(n):
#             for j in range(i + 1, n):
#                 matches.append([i, j])
#
#         ans = []
#         vis = [False] * len(matches)
#
#         def dfs(last: List[int]) -> bool:
#             if len(ans) == len(matches) and ans[0][0] not in last and ans[0][1] not in last:
#                 return True
#             for i, match in enumerate(matches):
#                 if vis[i] or match[0] in last or match[1] in last:
#                     continue
#                 vis[i] = True
#                 ans.append(match)
#                 if dfs(match):
#                     return True
#                 ans.remove(match)
#                 vis[i] = False
#             return False
#
#         dfs([-1, -1])
#         if len(ans) != len(matches):
#             return []
#
#         for i in range(n * (n - 1) // 2):
#             x, y = ans[i]
#             ans.append([y, x])
#
#         return ans
#
#
# print(Solution().generateSchedule(49))
