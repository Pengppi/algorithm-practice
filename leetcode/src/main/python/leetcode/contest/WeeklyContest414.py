from bisect import bisect_left
from typing import List


class Solution:
    def convertDateToBinary(self, date: str) -> str:
        year, month, day = map(int, date.split('-'))
        year = bin(year)[2:]
        month = bin(month)[2:]
        day = bin(day)[2:]
        return f'{year}-{month}-{day}'

    def maxPossibleScore(self, start: List[int], d: int) -> int:
        start.sort()
        n = len(start)

        def check(x):
            last = start[0]
            for i in range(1, n):
                diff = start[i] - last
                if diff + d < x:
                    return False
                last = max(last + x, start[i])
            return True

        left, right = 0, start[-1] + d - start[0]
        while left < right:
            mid = (left + right + 1) // 2
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left

    def findMaximumScore(self, nums: List[int]) -> int:
        n = len(nums)
        f = [0] * n
        bak = []
        for i in range(n):
            mx = i
            for j in bak:
                cur = f[j] + (i - j) * nums[j]
                if cur >= f[i]:
                    f[i] = cur
                    mx = j
            bak = [mx, i]
        return f[n - 1]

