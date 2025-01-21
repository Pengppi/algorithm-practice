"""
Title: 2266.统计打字方案数
Title Slug: countNumberOfTexts
Author: Neo
Date: 2025-01-19 15:41:07
"""
from itertools import groupby

# leetcode submit region begin(Prohibit modification and deletion)
mod = 10 ** 9 + 7

f = [1, 1, 2, 4]
g = [1, 1, 2, 4]
for _ in range(10 ** 5 - 3):  # 预处理所有长度的结果
    f.append((f[-1] + f[-2] + f[-3]) % mod)
    g.append((g[-1] + g[-2] + g[-3] + g[-4]) % mod)


class Solution:
    def countTexts(self, pressedKeys: str) -> int:
        ans = 1
        for ch, s in groupby(pressedKeys):
            m = len(list(s))
            ans = ans * (g[m] if ch in "79" else f[m]) % mod
        return ans

# leetcode submit region end(Prohibit modification and deletion)
