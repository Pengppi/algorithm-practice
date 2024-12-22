from collections import defaultdict, Counter
from functools import cache
from math import comb
from typing import List


class Solution:
    def subsequencesWithMiddleMode(self, nums: List[int]) -> int:
        mod = 10 ** 9 + 7
        n = len(nums)
        l = defaultdict(int)
        r = defaultdict(int)
        cnt = defaultdict(int)
        for i in range(n):
            l[i] = cnt[nums[i]]
            cnt[nums[i]] += 1
        cnt.clear()
        for i in range(n - 1, -1, -1):
            r[i] = cnt[nums[i]]
            cnt[nums[i]] += 1
        ans = 0

        vc = Counter(cnt.values())
        num_cnt = len(cnt)

        for i in range(2, n - 2):
            if l[i] == 0 and r[i] == 0:
                continue
        return ans

    def checkValidCuts(self, n: int, rectangles: List[List[int]]) -> bool:
        hor = list()
        ver = list()
        for x1, y1, x2, y2 in rectangles:
            hor.append([y1, y2])
            ver.append([x1, x2])

        def check(arr):
            cnt = 0
            arr.sort()
            mx = arr[0][1]
            for i in range(1, len(arr) - 1):
                if arr[i][0] < mx:
                    mx = max(mx, arr[i][1])
                else:
                    cnt += 1
                    if cnt == 2:
                        return True
                    mx = arr[i][1]
            return cnt >= 2

        return check(hor) or check(ver)

    def countPathsWithXorValue(self, grid: List[List[int]], k: int) -> int:
        mod = 10 ** 9 + 7
        m, n = len(grid), len(grid[0])

        @cache
        def dfs(x, y, xor):
            if x == m - 1 and y == n - 1:
                return 1 if xor == k else 0
            res = 0
            for dx, dy in [(0, 1), (1, 0)]:
                nx = x + dx
                ny = y + dy
                if nx >= m or nx < 0 or ny >= n or ny < 0:
                    continue
                res += dfs(nx, ny, xor ^ grid[nx][ny])
                res %= mod
            return res

        return dfs(0, 0, grid[0][0])

    def countSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(1, n - 1):
            if (nums[i - 1] + nums[i + 1]) * 2 == nums[i]:
                ans += 1
        return ans


print(comb(2, 1))
