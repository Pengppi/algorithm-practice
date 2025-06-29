"""
Title: 3445.奇偶频次间的最大差值 II
Title Slug: maximumDifferenceBetweenEvenAndOddFrequencyIi
Author: Neo
Date: 2025-06-11 12:29:07
"""
from cmath import inf


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxDifference(self, s: str, k: int) -> int:
        s = list(map(int, s))
        ans = -inf
        for x in range(5):
            for y in range(5):
                if x == y:
                    continue
                cur = [0] * 5
                pre = [0] * 5
                mn = [[inf] * 2 for _ in range(2)]
                l = 0
                for i, v in enumerate(s):
                    cur[v] += 1
                    r = i + 1
                    while r - l >= k and cur[x] > pre[x] and cur[y] > pre[y]:
                        p, q = pre[x] & 1, pre[y] & 1
                        mn[p][q] = min(mn[p][q], pre[x] - pre[y])
                        pre[s[l]] += 1
                        l += 1
                    if r >= k:
                        ans = max(ans, cur[x] - cur[y] - mn[cur[x] & 1 ^ 1][cur[y] & 1])

        return ans
# leetcode submit region end(Prohibit modification and deletion)
