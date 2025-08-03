"""
Title: 1900.The Earliest and Latest Rounds Where Players Compete
Title Slug: theEarliestAndLatestRoundsWherePlayersCompete
Author: Neo
Date: 2025-07-12 17:36:26
"""
from cmath import inf
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        @cache
        def dfs(n, a, b) -> List[int]:
            if a + b == n + 1:
                return [1, 1]
            if a + b > n + 1:
                a, b = n + 1 - b, n + 1 - a
            m = (n + 1) // 2
            # AB 之间保留 [min_mid, max_mid) 个人
            min_mid = 0 if b <= m else b - n // 2 - 1
            max_mid = b - a if b <= m else m - a
            earliest, latest = inf, 0

            for left in range(a):  # 枚举 A 左侧保留 left 个人
                for mid in range(min_mid, max_mid):  # 枚举 AB 之间保留 mid 个人
                    # 无需枚举 B 右侧保留多少个人，因为剩下的 m-2-left-mid 个人都在 B 右侧
                    e, l = dfs(m, left + 1, left + mid + 2)
                    earliest = min(earliest, e)
                    latest = max(latest, l)

            # 加上当前回合
            return [earliest + 1, latest + 1]

        return dfs(n,firstPlayer,secondPlayer)

# leetcode submit region end(Prohibit modification and deletion)
