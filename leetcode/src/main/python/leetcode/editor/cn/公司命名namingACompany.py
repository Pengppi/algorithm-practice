"""
Title: 2306.公司命名
Title Slug: namingACompany
Author: Neo
Date: 2024-09-25 12:46:12
"""
from collections import defaultdict
from itertools import combinations
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        g = defaultdict(set)
        for name in ideas:
            g[name[0]].add(name[1:])

        ans = 0
        for a, b in combinations(g.values(), 2):
            m = len(a & b)
            ans += (len(a) - m) * (len(b) - m)

        return ans * 2

# leetcode submit region end(Prohibit modification and deletion)
