from typing import List


class Solution:
    def minCosts(self, cost: List[int]) -> List[int]:
        mn = cost[0]
        n = len(cost)
        ans = [cost[0]] * n
        for i in range(1, n):
            mn = min(mn, cost[i])
            ans[i] = mn
        return ans

    def longestPalindrome(self, s: str, t: str) -> int:
        def fun(s):
            n = len(s)
            d = [1] * n
            for i in range(n - 2, -1, -1)

            return d

        m = len(s)
        n = len(t)
        t = t[::-1]
        f = [[0] * (n + 1) for _ in range(m + 1)]
        d1 = fun(s)
        d2 = fun(t)
        res = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if s[i - 1] == t[j - 1]:
                    f[i][j] = f[i - 1][j - 1] + 2
                    mid = 0
                    if i < m and j < n:
                        mid += max(d1[i], d2[j])
                    elif i < m:
                        mid += d1[i]
                    elif j < n:
                        mid += d2[j]
                    if f[i][j] + mid > res:
                        res = f[i][j] + mid
                else:
                    f[i][j] = 0
        return max(res, max(*d1, *d2))


Solution().longestPalindrome("wbrbvo", "w")
