from collections import defaultdict, Counter
from functools import cache
from typing import List


class Solution:
    def maxScore(self, nums: List[int]) -> int:
        def gcd(a, b):
            while b != 0:
                a, b = b, a % b
            return a

        def lcm(a, b):
            return a * b // gcd(a, b)

        n = len(nums)
        ol = nums[0]
        og = nums[0]
        for num in nums[1:]:
            og = gcd(og, num)
            ol = lcm(ol, num)
        os = ol * og
        ans = os
        for i in range(n):
            new_nums = nums[:i] + nums[i + 1:]
            if not new_nums:
                continue
            nl = new_nums[0]
            ng = new_nums[0]
            for num in new_nums[1:]:
                ng = gcd(ng, num)
                nl = lcm(nl, num)
            score = nl * ng
            ans = max(ans, score)
        return ans

    def lengthAfterTransformations2(self, s: str, t: int) -> int:
        z = ord("z")
        a = ord("a")
        b = ord("b")
        mod = 10 ** 9 + 7

        @cache
        def get(i, t):
            nt = t - (z - i)
            if nt <= 0:
                return 1
            else:
                return (get(a, nt - 1) + get(b, nt - 1)) % mod

        ans = 0
        for c in s:
            ans += get(ord(c), t)
            ans %= mod
        return ans

    def subsequencePairCount(self, nums: List[int]) -> int:
        mod = 10 ** 9 + 7
        n = len(nums)

        def gcd(a, b):
            while b != 0:
                a, b = b, a % b
            return a

        mp = defaultdict(list)
        ans = 0
        for i in range(1, 1 << n):
            gd = 0
            for j in range(n):
                mask = 1 << j
                if mask > i:
                    break
                if i & mask:
                    gd = gcd(gd, nums[j])

            for j in mp[gd]:
                if i & j == 0:
                    ans += 1
            mp[gd].append(i)
            ans %= mod
        return (ans * 2) % mod

    def lengthAfterTransformations(self, s: str, t: int, nums: List[int]) -> int:
        mod = 10 ** 9 + 7

        dp = [1] * 26
        for _ in range(t):
            new_dp = [0] * 26
            for i in range(26):
                for k in range(nums[i]):
                    j = (i + 1 + k) % 26
                    new_dp[i] += dp[j]
                    new_dp[i] %= mod
            dp = new_dp

        ans = 0
        for (c, cnt) in Counter(s).items():
            i = ord(c) - ord("a")
            ans += dp[i] * cnt
            ans %= mod
        return ans
