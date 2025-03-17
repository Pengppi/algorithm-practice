"""
Title: 2070.每一个查询的最大美丽值
Title Slug: mostBeautifulItemForEachQuery
Author: Neo
Date: 2025-03-09 22:13:19
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        n = len(queries)
        ans = [0] * n
        items.sort(key=lambda x: x[0])
        curMx = 0
        j = 0
        for i in sorted(range(n), key=lambda x: queries[x]):
            curPrice = queries[i]
            while j < len(items) and items[j][0] <= curPrice:
                curMx = max(curMx, items[j][1])
                j += 1
            ans[i] = curMx
        return ans
# leetcode submit region end(Prohibit modification and deletion)
