"""
Title: 3186.Maximum Total Damage With Spell Casting
Title Slug: maximumTotalDamageWithSpellCasting
Author: Neo
Date: 2025-10-11 22:16:01
"""
from collections import defaultdict, Counter
from functools import lru_cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        map = defaultdict(int)
        for x in power:
            map[x] += x
        a = sorted(map.keys())
        n = len(a)

        @lru_cache(None)
        def dfs(i: int) -> int:
            if i < 0:
                return 0
            x = a[i]
            j = i - 1
            while j >= 0 and a[j] >= x - 2:
                j -= 1
            return max(dfs(i - 1), map[x] + dfs(j))

        return dfs(n - 1)


# leetcode submit region end(Prohibit modification and deletion)
Solution().maximumTotalDamage([1, 1, 3, 4])
