import heapq
from typing import List


class Solution:

    def maxSum(self, grid: List[List[int]], limits: List[int], k: int) -> int:
        h = []
        for i, row in enumerate(grid):
            for j, num in enumerate(row):
                h.append((-num, i))

        heapq.heapify(h)
        ans = 0
        while k > 0:
            while h and limits[h[0][1]] <= 0:
                heapq.heappop(h)
            num, i = heapq.heappop(h)
            limits[i] -= 1
            ans -= num
            k -= 1

        return ans

    def hasSameDigits(self, s: str) -> bool:
        n = len(s)
        nums = [int(c) for c in s]

        def count(l, r, k):
            res = 0
            while l <= r:
                if l == r:
                    res += nums[l] * k % 10
                else:
                    res += nums[l] * k % 10
                    res += nums[r] * k % 10
                l += 1
                r -= 1
                k += 2
            return res

        left = (nums[0] + nums[-2]) % 10 + count(1, n - 3, n - 2)
        right = (nums[- 1] + nums[1]) % 10 + count(2, n - 2, n - 2)
        return left % 10 == right % 10


print(-21 % 10)

res = Solution().hasSameDigits("321881")
print(res)
# 55 71
# 15 11
