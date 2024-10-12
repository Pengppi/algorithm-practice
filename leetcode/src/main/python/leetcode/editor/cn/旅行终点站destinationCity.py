"""
Title: 1436.旅行终点站
Title Slug: destinationCity
Author: Neo
Date: 2024-10-08 12:06:51
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        cities = set()
        out_cnt = defaultdict(int)
        for a, b in paths:
            cities.add(a)
            cities.add(b)
            out_cnt[a] += 1

        for city in cities:
            if out_cnt[city] == 0:
                return city
        return ""

# leetcode submit region end(Prohibit modification and deletion)
