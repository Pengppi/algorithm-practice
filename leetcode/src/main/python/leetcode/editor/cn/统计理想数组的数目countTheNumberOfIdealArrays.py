"""
Title: 2338.统计理想数组的数目
Title Slug: countTheNumberOfIdealArrays
Author: Neo
Date: 2025-04-22 19:53:05
"""
from math import comb

# leetcode submit region begin(Prohibit modification and deletion)
MOD = 10 ** 9 + 7
MX_VAL = 10000
# x 中的质因子 i 的出现次数
FACTOR_CNT = [[] for _ in range(MX_VAL + 1)]

for x in range(2, len(FACTOR_CNT)):
    t = x
    i = 2
    while i * i <= t:
        cnt = 0
        while t % i == 0:
            cnt += 1
            t //= i
        if cnt > 0:
            FACTOR_CNT[x].append(cnt)
        i += 1
    if t > 1:
        FACTOR_CNT[x].append(1)


class Solution:
    def idealArrays(self, n: int, maxValue: int) -> int:
        ans = 0
        for num in range(1, maxValue + 1):
            res = 1
            for c in FACTOR_CNT[num]:
                res = res * comb(n - 1 + c, c) % MOD
            ans += res
            ans %= MOD

        return ans

# leetcode submit region end(Prohibit modification and deletion)
