from cmath import inf
from functools import cache
from typing import List


class Solution:
    def reverseDegree(self, s: str) -> int:
        ans = 0
        for i, c in enumerate(s, 1):
            ans += i * (26 - (ord(c) - ord('a')))
        return ans

    def maxActiveSectionsAfterTrade(self, s: str) -> int:
        origin = s.count('1')
        s = '1' + s + '1'
        ans = origin
        n = len(s)
        l = 0
        has_zero = 0
        has_one = 0
        r = 0
        while r <= n:
            if s[r] == '1':
                if not has_zero:
                    l = r
                    r += 1
                    continue
                if has_one:
                    if s[r - 1] != '1':
                        ans = max(ans, origin + has_zero)
                        l = has_one
                        r = l
                        has_zero = 0
                        has_one = 0
                    else:
                        has_one = r
                else:
                    has_one = r
            else:
                has_zero += 1
            r += 1

        return ans

    def minimumCost1(self, nums: List[int], cost: List[int], k: int) -> int:
        n = len(nums)
        num_sum = [0] * (n + 1)
        cost_sum = [0] * (n + 1)

        for i in range(n):
            num_sum[i + 1] = num_sum[i] + nums[i]
            cost_sum[i + 1] = cost_sum[i] + cost[i]

        @cache
        def dfs(l, cnt, x):
            if x == n:
                return (num_sum[x] + k * cnt) * (cost_sum[x] - cost_sum[l])
            res1 = dfs(l, cnt, x + 1)
            cur = (num_sum[x + 1] + k * cnt) * (cost_sum[x + 1] - cost_sum[l])
            if cur > res1:
                return res1
            return min(res1, cur + dfs(x + 1, cnt + 1, x + 1))

        ans = dfs(0, 1, 0)
        dfs.cache_clear()
        return ans
