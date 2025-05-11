"""
Title: 1128.等价多米诺骨牌对的数量
Title Slug: numberOfEquivalentDominoPairs
Author: Neo
Date: 2025-05-04 10:51:39
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        mp = defaultdict(list)
        ans = 0
        for i, (a, b) in enumerate(dominoes):
            for j in mp[a + b]:
                c, d = dominoes[j]
                if (a == c and b == d) or (a == d and b == c):
                    ans += 1
            mp[a + b].append(i)
        return ans
            # leetcode submit region end(Prohibit modification and deletion)
